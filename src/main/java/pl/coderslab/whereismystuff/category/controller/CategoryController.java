package pl.coderslab.whereismystuff.category.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.category.service.CategoryService;
import pl.coderslab.whereismystuff.security.CurrentUser;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/app/category")
public class CategoryController {

    private final CategoryService categoryService;
    private CurrentUser currentUser;

    @ModelAttribute
    public CurrentUser getCurrentUser(@AuthenticationPrincipal CurrentUser currentUser) {
        this.currentUser = currentUser;
        return currentUser;
    }

    @GetMapping("all")
    public String allCategories(Model model) {
        model.addAttribute("categories", categoryService.findAllByUser(currentUser.getUser()));
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

    @GetMapping("/edit/{categoryId}")
    public String editCategoryForm(@PathVariable long categoryId, Model model) {
        Category category = categoryService.findById(categoryId).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
        if (!currentUser.getUser().equals(category.getUser())) {
            throw new AccessDeniedException("Access denied");
        }
        model.addAttribute("category", category);
        return "category/edit-form";
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
    public String deleteConfirm(@PathVariable long categoryId, Model model) {
        Category toDelete = categoryService.findById(categoryId).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
        if (!currentUser.getUser().equals(toDelete.getUser())) {
            throw new AccessDeniedException("Access denied");
        }
        model.addAttribute("categoryId", categoryId);
        return "category/confirm";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam long categoryId) {
        categoryService.delete(categoryId);
        return "redirect:/app/category/all";
    }

}

