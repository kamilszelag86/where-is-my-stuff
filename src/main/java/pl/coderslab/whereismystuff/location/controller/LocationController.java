package pl.coderslab.whereismystuff.location.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.method.P;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.location.service.LocationService;
import pl.coderslab.whereismystuff.security.CurrentUser;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/location")
public class LocationController {

    private final LocationService locationService;
    private CurrentUser currentUser;

    @ModelAttribute
    public CurrentUser getCurrentUser(@AuthenticationPrincipal CurrentUser currentUser) {
        this.currentUser = currentUser;
        return currentUser;
    }

    @GetMapping("/all")
    public String allCategories(Model model) {
        model.addAttribute("locations", locationService.findAllByUser(currentUser.getUser()));
        return "location/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("location", new Location());
        return "location/add-form";
    }

    @PostMapping("/add")
    public String createLocation(@Valid Location location, BindingResult result) {
        if (result.hasErrors()) {
            return "location/add-form";
        }
        locationService.create(location);
        return "redirect:/app/location/all";
    }

    @GetMapping("/edit/{locationId}")
    public String editForm(@PathVariable long locationId, Model model) {
        Location toEdit = locationService.findById(locationId).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
        if (!currentUser.getUser().equals(toEdit.getUser())) {
            throw new AccessDeniedException("Access denied");
        }
        model.addAttribute("location", toEdit);
        return "location/edit-form";
    }

    @PostMapping("/edit")
    public String editLocation(@Valid Location location, BindingResult result) {
        if (result.hasErrors()) {
            return "location/edit-form";
        }
        locationService.update(location);
        return "redirect:/app/location/all";
    }

    @GetMapping("/delete/{locationId}")
    public String deleteConfirm(@PathVariable long locationId, Model model) {
        Location toDelete = locationService.findById(locationId).orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
        if (!currentUser.getUser().equals(toDelete.getUser())) {
            throw new AccessDeniedException("Access denied");
        }
        model.addAttribute("locationId", locationId);
        return "location/confirm";
    }

    @PostMapping("/delete")
    private String deleteLocation(@RequestParam long locationId) {
        locationService.delete(locationId);
        return "redirect:/app/location/all";
    }

}
