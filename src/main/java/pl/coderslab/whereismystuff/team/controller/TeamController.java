package pl.coderslab.whereismystuff.team.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.whereismystuff.security.entity.CurrentUser;
import pl.coderslab.whereismystuff.team.entity.JoinTeamRequest;
import pl.coderslab.whereismystuff.team.service.TeamService;
import pl.coderslab.whereismystuff.user.entity.User;
import pl.coderslab.whereismystuff.user.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/team")
public class TeamController {

    private final TeamService teamService;
    private final UserService userService;

    @ModelAttribute("activeRequests")
    public List<JoinTeamRequest> activeRequests(@AuthenticationPrincipal CurrentUser currentUser) {
        return teamService.findAllActiveJoinRequests(currentUser.getUser().getTeam());
    }

    @ModelAttribute("teamMembers")
    public List<User> teamMembers(@AuthenticationPrincipal CurrentUser currentUser) {
        return userService.findAllByTeam(currentUser.getUser().getTeam());
    }

    @GetMapping
    public String showTeam() {
        return "team/show";
    }

}
