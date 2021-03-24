package pl.coderslab.whereismystuff.team.service;

import pl.coderslab.whereismystuff.team.entity.JoinTeamRequest;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface TeamService {

    List<Team> findAll();

    Team create(Team team);

    void createJoinTeamRequest(Team team, User user);

    List<JoinTeamRequest> findAllActiveJoinRequests(Team team);

    void approveJoinTeamRequest(JoinTeamRequest request);

    void rejectJoinTeamRequest(JoinTeamRequest request);

}
