package pl.coderslab.whereismystuff.item.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.category.service.CategoryService;
import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.item.service.ItemService;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.location.service.LocationService;
import pl.coderslab.whereismystuff.security.entity.CurrentUser;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/item")
public class ItemController {

    private final ItemService itemService;
    private final CategoryService categoryService;
    private final LocationService locationService;

    @ModelAttribute(name = "categories")
    public List<Category> categories(@AuthenticationPrincipal CurrentUser currentUser) {
        return categoryService.findAllByTeam(currentUser.getUser().getTeam());
    }

    @ModelAttribute(name = "locations")
    public List<Location> locations(@AuthenticationPrincipal CurrentUser currentUser) {
        return locationService.findAllByTeam(currentUser.getUser().getTeam());
    }

    @GetMapping("/all")
    public String allItems(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("items", itemService.findAllByTeam(currentUser.getUser().getTeam()));
        return "item/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "item/add-form";
    }

    @PostMapping("/add")
    public String add(@Valid Item item, BindingResult result,
                      @RequestParam("image") MultipartFile image,
                      @RequestParam("receipt") MultipartFile receipt) throws IOException {
        if (result.hasErrors()) {
            return "item/add-form";
        }
        Item created = itemService.create(item);
        if (!image.isEmpty()) {
            itemService.setItemImage(created, image);
        }
        if (!receipt.isEmpty()) {
            itemService.setReceiptImage(created, receipt);
        }
        return "redirect:/app/item/all";
    }

    @GetMapping("/edit/{itemId}")
    public String editForm(@PathVariable long itemId, Model model,
                           @AuthenticationPrincipal CurrentUser currentUser) {
        try {
            Item toEdit = itemService.findById(itemId);
            if (!currentUser.getUser().getTeam().equals(toEdit.getTeam())) {
                throw new AccessDeniedException("Access denied");
            }
            model.addAttribute("item", toEdit);
            return "item/edit-form";
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit")
    public String editItem(@Valid Item item, BindingResult result,
                           @RequestParam("image") MultipartFile image,
                           @RequestParam("receipt") MultipartFile receipt) throws IOException {
        if (result.hasErrors()) {
            return "item/edit-form";
        }
        Item updated = itemService.update(item);
        if (!image.isEmpty()) {
            itemService.setItemImage(updated, image);
        }
        if (!receipt.isEmpty()) {
            itemService.setReceiptImage(updated, receipt);
        }
        return "redirect:/app/item/all";
    }

    @GetMapping("/delete/{itemId}")
    public String deleteConfirm(@PathVariable long itemId, Model model,
                                @AuthenticationPrincipal CurrentUser currentUser) {
        try {
            Item toDelete = itemService.findById(itemId);
            if (!currentUser.getUser().getTeam().equals(toDelete.getTeam())) {
                throw new AccessDeniedException("Access denied");
            }
            model.addAttribute("itemId", itemId);
            return "item/confirm";
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam Item item) throws IOException {
        itemService.delete(item);
        return "redirect:/app/item/all";
    }

    @GetMapping("show/{itemId}")
    public String showItem(@PathVariable long itemId, Model model,
                           @AuthenticationPrincipal CurrentUser currentUser) {
        try {
            Item item = itemService.findById(itemId);
            if (!currentUser.getUser().equals(item.getUser())) {
                throw new AccessDeniedException("Access denied");
            }
            model.addAttribute("item", item);
            return "item/show";
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/image")
    public String addImage(@RequestParam Item item, MultipartFile image) throws IOException {
        if (!image.isEmpty()) {
            itemService.setItemImage(item, image);
        }
        return "redirect:/app/item/show/" + item.getId();
    }

    @PostMapping("/receipt")
    public String addReceipt(@RequestParam Item item, MultipartFile receipt) throws IOException {
        if (!receipt.isEmpty()) {
            itemService.setReceiptImage(item, receipt);
        }
        return "redirect:/app/item/show/" + item.getId();
    }

    @PostMapping("/location")
    public String setLocation(@RequestParam(name = "itemsToMove", required = false) List<Item> itemsToMove,
                              @RequestParam Location location) {
        if (itemsToMove != null && !itemsToMove.isEmpty()) {
            itemService.setLocation(itemsToMove, location);
        }
        return "redirect:/app/item/all";
    }

}