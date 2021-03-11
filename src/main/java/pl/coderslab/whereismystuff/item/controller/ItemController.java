package pl.coderslab.whereismystuff.item.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.category.service.CategoryService;
import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.item.service.ItemService;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.location.service.LocationService;
import pl.coderslab.whereismystuff.security.CurrentUser;
import pl.coderslab.whereismystuff.utils.FileUploadUtil;

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

    @ModelAttribute
    public CurrentUser getCurrentUser(@AuthenticationPrincipal CurrentUser currentUser) {
        return currentUser;
    }

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
    public String add(@Valid Item item, BindingResult result,
                      @RequestParam("image") MultipartFile multipartFile) throws IOException {
        if (result.hasErrors()) {
            return "item/add-form";
        }
        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            item.setItemImage(fileName);
            Item created = itemService.create(item);
            String uploadDir = "item-images/" + created.getId();
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            return "redirect:/app/item/all";
        }
        itemService.create(item);
        return "redirect:/app/item/all";
    }

    @GetMapping("/edit/{itemId}")
    public String editForm(@PathVariable long itemId, Model model,
                           @AuthenticationPrincipal CurrentUser currentUser) {
        Item toEdit = itemService.findById(itemId).orElseThrow(EntityNotFoundException::new);
        if (!currentUser.getUser().equals(toEdit.getUser())) {
            throw new AccessDeniedException("Access denied");
        }
        model.addAttribute("item", toEdit);
        return "item/edit-form";
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
        Item toDelete = itemService.findById(itemId).orElseThrow(EntityNotFoundException::new);
        if (!currentUser.getUser().equals(toDelete.getUser())) {
            throw new AccessDeniedException("Access denied");
        }
        model.addAttribute("itemId", itemId);
        return "item/confirm";
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam long itemId) {
        itemService.delete(itemId);
        return "redirect:/app/item/all";
    }

}

