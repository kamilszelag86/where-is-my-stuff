package pl.coderslab.whereismystuff.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.whereismystuff.user.entity.User;
import pl.coderslab.whereismystuff.user.service.CurrentUser;

@Controller
public class HomeController {

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

}
