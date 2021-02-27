package pl.coderslab.whereismystuff.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.whereismystuff.user.entity.User;
import pl.coderslab.whereismystuff.user.service.CurrentUser;
import pl.coderslab.whereismystuff.user.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;


    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser currentUser) {
        User entityUser = currentUser.getUser();
        return "Hello " + entityUser.getUsername();
    }

    @GetMapping("register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/register";
        }
        userService.saveUser(user);
        return "/about";
    }

}
