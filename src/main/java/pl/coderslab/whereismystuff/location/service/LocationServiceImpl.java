package pl.coderslab.whereismystuff.location.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.location.repository.LocationRepository;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public List<Location> findAllByUser(User user) {
        return locationRepository.findAllByUserOrderByNameAsc(user);
    }

    @Override
    public Location findById(long id) throws EntityNotFoundException {
        return locationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void create(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void update(Location location) {
        if (locationRepository.existsById(location.getId())) {
            locationRepository.save(location);
        }
    }

    @Override
    public void delete(long locationId) {
        if (locationRepository.existsById(locationId)) {
            locationRepository.deleteById(locationId);
        }
    }

}
