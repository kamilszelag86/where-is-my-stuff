package pl.coderslab.whereismystuff.team.service;

import pl.coderslab.whereismystuff.team.entity.Team;

import java.util.List;

public interface TeamService {

    List<Team> findAll();

    Team create(Team team);

}
