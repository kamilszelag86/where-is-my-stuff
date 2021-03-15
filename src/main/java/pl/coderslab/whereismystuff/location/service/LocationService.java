package pl.coderslab.whereismystuff.location.service;

import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface LocationService {

    List<Location> findAllByUser(User user);

    List<Location> findAllByTeam(Team team);

    Location findById(long id);

    void create(Location location);

    void update(Location location);

    void delete(long locationId);

}
