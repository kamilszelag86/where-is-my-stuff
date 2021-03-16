package pl.coderslab.whereismystuff.item.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
        return categoryService.findAllByUser(currentUser.getUser());
    }

    @ModelAttribute(name = "locations")
    public List<Location> locations(@AuthenticationPrincipal CurrentUser currentUser) {
        return locationService.findAllByUser(currentUser.getUser());
    }

    @GetMapping("/all")
    public String allItems(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("items", itemService.findAllByUser(currentUser.getUser()));
        return "item/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "item/add-form";
    }

    @PostMapping("/add")
    public String add(@Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item/add-form";
        }
        itemService.create(item);
        return "redirect:/app/item/all";
    }

    @GetMapping("/edit/{itemId}")
    public String editForm(@PathVariable long itemId, Model model,
                           @AuthenticationPrincipal CurrentUser currentUser) {
        try {
            Item toEdit = itemService.findById(itemId);
            if (!currentUser.getUser().equals(toEdit.getUser())) {
                throw new AccessDeniedException("Access denied");
            }
            model.addAttribute("item", toEdit);
            return "item/edit-form";
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit")
    public String editItem(@Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item/edit-form";
        }
        itemService.update(item);
        return "redirect:/app/item/all";
    }

    @GetMapping("/delete/{itemId}")
    public String deleteConfirm(@PathVariable long itemId, Model model,
                                @AuthenticationPrincipal CurrentUser currentUser) {
        try {
            Item toDelete = itemService.findById(itemId);
            if (!currentUser.getUser().equals(toDelete.getUser())) {
                throw new AccessDeniedException("Access denied");
            }
            model.addAttribute("itemId", itemId);
            return "item/confirm";
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam long itemId) {
        itemService.delete(itemId);
        return "redirect:/app/item/all";
    }

}

