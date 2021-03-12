package pl.coderslab.whereismystuff.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.whereismystuff.security.CurrentUser;
import pl.coderslab.whereismystuff.user.dto.UserDto;
import pl.coderslab.whereismystuff.user.dto.UserDtoConverter;
import pl.coderslab.whereismystuff.user.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    private final UserDtoConverter userDtoConverter;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "user/register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute("user") @Valid UserDto user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            if (result.hasGlobalErrors()) {
                result.getGlobalErrors().stream()
                        .filter(e -> "ConfirmedPassword".equals(e.getCode()))
                        .forEach(e -> model.addAttribute("confirmMessage", e.getDefaultMessage()));
            }
            return "user/register";
        }
        userService.createUser(userDtoConverter.toEntity(user));
        return "redirect:/login";
    }

    @GetMapping("/app")
    public String dashboard(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser", currentUser);
        return "dashboard";
    }

}
