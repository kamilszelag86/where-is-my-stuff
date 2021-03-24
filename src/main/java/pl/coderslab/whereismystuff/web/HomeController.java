package pl.coderslab.whereismystuff.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.whereismystuff.security.entity.CurrentUser;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.team.service.TeamService;
import pl.coderslab.whereismystuff.user.dto.UserDto;
import pl.coderslab.whereismystuff.user.dto.UserDtoConverter;
import pl.coderslab.whereismystuff.user.entity.User;
import pl.coderslab.whereismystuff.user.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private static final String CONFIRMED_PASSWORD_ERROR_CODE = "ConfirmedPassword";

    private final UserService userService;
    private final TeamService teamService;

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
            result.getGlobalErrors().stream()
                    .filter(e -> CONFIRMED_PASSWORD_ERROR_CODE.equals(e.getCode()))
                    .findFirst()
                    .ifPresent(e -> model.addAttribute("confirmMessage", e.getDefaultMessage()));
            return "user/register";
        }
        userService.createUser(UserDtoConverter.toEntity(user));
        return "redirect:/login";
    }

    @GetMapping("/app")
    public String dashboard(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        if (currentUser.getUser().getTeam() != null) {
            return "dashboard";
        } else {
            model.addAttribute("newTeam", new Team());
            model.addAttribute("teams", teamService.findAll());
            return "user/select-team";
        }
    }

}