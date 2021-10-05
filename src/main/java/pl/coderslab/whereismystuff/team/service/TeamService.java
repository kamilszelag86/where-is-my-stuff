package pl.coderslab.whereismystuff.team.service;

import pl.coderslab.whereismystuff.team.entity.JoinTeamRequest;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface TeamService {

    Team findByName(String teamName);

    List<Team> findAll();

    Team create(Team team, User user);

    void createJoinTeamRequest(Team team, User user);

    void deleteJoinTeamRequest(JoinTeamRequest request);

    List<JoinTeamRequest> findAllActiveJoinRequests(Team team);

    void approveJoinTeamRequest(JoinTeamRequest request);

    void rejectJoinTeamRequest(JoinTeamRequest request);

}
