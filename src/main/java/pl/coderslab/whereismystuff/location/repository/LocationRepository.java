package pl.coderslab.whereismystuff.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findAllByUser(User user);

}
