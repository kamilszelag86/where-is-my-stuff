package pl.coderslab.whereismystuff.location.service;

import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface LocationService {

    List<Location> findAllByUser(User user);

    void save(Location location);

}
