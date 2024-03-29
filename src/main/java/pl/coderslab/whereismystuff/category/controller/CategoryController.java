package pl.coderslab.whereismystuff.category.controller;

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
import pl.coderslab.whereismystuff.item.service.ItemService;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.security.entity.CurrentUser;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final ItemService itemService;

    @GetMapping("all")
    public String allCategories(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("categories", categoryService.findAllByTeam(currentUser.getUser().getTeam()));
        return "category/list";
    }

    @GetMapping("/add")
    public String categoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add-form";
    }

    @PostMapping("/add")
    public String addCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/add-form";
        }
        categoryService.save(category);
        return "redirect:/app/category/all";
    }

    @GetMapping("/show/{categoryId}")
    public String showLocation(@AuthenticationPrincipal CurrentUser currentUser,
                               @PathVariable long categoryId, Model model) {
        try {
            Category category = categoryService.findById(categoryId);
            if (!currentUser.getUser().getTeam().equals(category.getTeam())) {
                throw new AccessDeniedException("Access denied");
            }
            model.addAttribute("category", category);
            model.addAttribute("items", itemService.findAllByCategory(category));
            return "category/show";
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/edit/{categoryId}")
    public String editCategoryForm(@AuthenticationPrincipal CurrentUser currentUser,
                                   @PathVariable long categoryId, Model model) {
        try {
            Category toEdit = categoryService.findById(categoryId);
            if (!currentUser.getUser().getTeam().equals(toEdit.getTeam())) {
                throw new AccessDeniedException("Access denied");
            }
            model.addAttribute("category", toEdit);
            return "category/edit-form";
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit")
    public String editCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/edit-form";
        }
        categoryService.update(category);
        return "redirect:/app/category/all";
    }

    @GetMapping("/delete/{categoryId}")
    public String deleteConfirm(@AuthenticationPrincipal CurrentUser currentUser,
                                @PathVariable long categoryId, Model model) {
        try {
            Category toDelete = categoryService.findById(categoryId);
            if (!currentUser.getUser().getTeam().equals(toDelete.getTeam())) {
                throw new AccessDeniedException("Access denied");
            }
            model.addAttribute("categoryId", categoryId);
            return "category/confirm";
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam long categoryId) {
        categoryService.delete(categoryId);
        return "redirect:/app/category/all";
    }

}

