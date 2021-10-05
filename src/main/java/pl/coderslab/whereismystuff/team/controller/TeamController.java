package pl.coderslab.whereismystuff.team.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.whereismystuff.security.entity.CurrentUser;
import pl.coderslab.whereismystuff.team.entity.JoinTeamRequest;
import pl.coderslab.whereismystuff.team.entity.JoinTeamRequestStatus;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.team.service.TeamService;
import pl.coderslab.whereismystuff.user.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/team")
public class TeamController {

    private final TeamService teamService;
    private final UserService userService;

    @GetMapping
    public String showTeam(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("activeRequests", teamService.findAllActiveJoinRequests(currentUser.getUser().getTeam()));
        model.addAttribute("teamMembers", userService.findAllByTeam(currentUser.getUser().getTeam()));
        return "team/show";
    }

    @PostMapping("/create")
    public String createTeam(@ModelAttribute("newTeam") @Valid Team team, BindingResult result,
                             @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "user/select-team";
        }
        teamService.create(team, currentUser.getUser());
        return "redirect:/app";
    }

    @PostMapping("/join")
    public String joinTeam(@RequestParam String teamName, Model model,
                           @AuthenticationPrincipal CurrentUser currentUser) {
        Team team = teamService.findByName(teamName);
        if (team == null) {
            model.addAttribute("newTeam", new Team());
            model.addAttribute("invalidTeam", true);
            return "user/select-team";
        }
        teamService.createJoinTeamRequest(team, currentUser.getUser());
        return "redirect:/app";
    }

    @PostMapping("/request/cancel")
    public String cancelJoinTeamRequest(@RequestParam("request") JoinTeamRequest request,
                                 @AuthenticationPrincipal CurrentUser currentUser) {
        if (JoinTeamRequestStatus.ACTIVE.equals(request.getStatus())) {
            teamService.deleteJoinTeamRequest(request);
            currentUser.getUser().setJoinTeamRequest(null);
        }
        return "redirect:/app";
    }

    @PostMapping("/request/delete")
    public String deleteJoinTeamRequest(@RequestParam("request") JoinTeamRequest request,
                                        @AuthenticationPrincipal CurrentUser currentUser) {
        teamService.deleteJoinTeamRequest(request);
        currentUser.getUser().setJoinTeamRequest(null);
        return "redirect:/app";
    }

    @PostMapping("/approve")
    public String approve(@RequestParam("request") JoinTeamRequest request) {
        teamService.approveJoinTeamRequest(request);
        return "redirect:/app/team";
    }

    @PostMapping("/reject")
    public String reject(@RequestParam("request") JoinTeamRequest request) {
        teamService.rejectJoinTeamRequest(request);
        return "redirect:/app/team";
    }

}
