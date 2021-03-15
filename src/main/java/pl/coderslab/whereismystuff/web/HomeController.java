package pl.coderslab.whereismystuff.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.whereismystuff.security.CurrentUser;
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
                    .filter(e -> "ConfirmedPassword".equals(e.getCode()))
                    .findFirst()
                    .ifPresent(e -> model.addAttribute("confirmMessage", e.getDefaultMessage()));
            return "user/register";
        }
        userService.createUser(UserDtoConverter.toEntity(user));
        return "redirect:/login";
    }

    @GetMapping("/app")
    public String dashboard(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser", currentUser);
        if (currentUser.getUser().getTeam() != null) {
            return "dashboard";
        } else {
            model.addAttribute("newTeam", new Team());
            model.addAttribute("teams", teamService.findAll());
            return "user/select-team";
        }
    }

    @PostMapping("app/team/create")
    public String createTeam(@ModelAttribute("newTeam") @Valid Team team, BindingResult result,
                             @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "user/select-team";
        }
        Team created = teamService.create(team);
        setTeamForUser(created, currentUser);
        return "redirect:/app";
    }

    @PostMapping("app/team/add")
    public String joinTeam(@RequestParam Team team, @AuthenticationPrincipal CurrentUser currentUser) {
        setTeamForUser(team, currentUser);
        return "redirect:/app";
    }

    private void setTeamForUser(Team team, CurrentUser currentUser) {
        User user = currentUser.getUser();
        user.setTeam(team);
        userService.updateUser(user);
    }

}