package pl.coderslab.whereismystuff.location.service;

import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    List<Location> findAllByUser(User user);

    Optional<Location> findById(long id);

    void create(Location location);

    void update(Location location);

    void delete(long locationId);

}
