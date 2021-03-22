package pl.coderslab.whereismystuff.location.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.whereismystuff.item.service.ItemService;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.location.service.LocationService;
import pl.coderslab.whereismystuff.security.entity.CurrentUser;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/location")
public class LocationController {

    private final LocationService locationService;
    private final ItemService itemService;

    @GetMapping("/all")
    public String allCategories(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("locations", locationService.findAllByTeam(currentUser.getUser().getTeam()));
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

    @GetMapping("/show/{locationId}")
    public String showLocation(@AuthenticationPrincipal CurrentUser currentUser,
                               @PathVariable long locationId, Model model) {
        try {
            Location location = locationService.findById(locationId);
            if (!currentUser.getUser().getTeam().equals(location.getTeam())) {
                throw new AccessDeniedException("Access denied");
            }
            model.addAttribute("location", location);
            model.addAttribute("items", itemService.findAllByLocation(location));
            return "location/show";
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/edit/{locationId}")
    public String editForm(@AuthenticationPrincipal CurrentUser currentUser,
                           @PathVariable long locationId, Model model) {
        try {
            Location toEdit = locationService.findById(locationId);
            if (!currentUser.getUser().getTeam().equals(toEdit.getTeam())) {
                throw new AccessDeniedException("Access denied");
            }
            model.addAttribute("location", toEdit);
            return "location/edit-form";
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
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
    public String deleteConfirm(@AuthenticationPrincipal CurrentUser currentUser,
                                @PathVariable long locationId, Model model) {
        try {
            Location toDelete = locationService.findById(locationId);
            if (!currentUser.getUser().getTeam().equals(toDelete.getTeam())) {
                throw new AccessDeniedException("Access denied");
            }
            model.addAttribute("isEmpty", !itemService.existsByLocation(toDelete));
            model.addAttribute("locationId", locationId);
            return "location/confirm";
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete")
    private String deleteLocation(@RequestParam long locationId) {
        locationService.delete(locationId);
        return "redirect:/app/location/all";
    }

}
