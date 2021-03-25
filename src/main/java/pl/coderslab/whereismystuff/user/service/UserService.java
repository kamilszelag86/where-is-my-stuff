package pl.coderslab.whereismystuff.user.service;

import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface UserService {

    User findByUsername(String username);

    void createUser(User user);

    void updateUser(User user);

    void setTeamForUser(Team team, User user);

    List<User> findAllByTeam(Team team);

}
