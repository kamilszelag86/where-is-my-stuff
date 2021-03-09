package pl.coderslab.whereismystuff.item.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.item.service.ItemService;
import pl.coderslab.whereismystuff.security.CurrentUser;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/item")
public class ItemController {

    private final ItemService itemService;
    private CurrentUser currentUser;

    @ModelAttribute
    public CurrentUser getCurrentUser(@AuthenticationPrincipal CurrentUser currentUser) {
        this.currentUser = currentUser;
        return currentUser;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "item/form";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(Item item) {
        item.setUser(currentUser.getUser());
        itemService.save(item);
        return "dodano";
    }

    @GetMapping("/all")
    public String show(Model model) {
        model.addAttribute("items", itemService.findAllByUser(currentUser.getUser()));
        return "item/list";
    }

}
