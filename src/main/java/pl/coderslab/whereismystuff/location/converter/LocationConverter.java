package pl.coderslab.whereismystuff.location.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.location.service.LocationService;

import javax.persistence.EntityNotFoundException;

public class LocationConverter implements Converter<String, Location> {

    @Autowired
    private LocationService locationService;

    @Override
    public Location convert(String s) {
        try {
            return locationService.findById(Long.parseLong(s));
        } catch (EntityNotFoundException e) {
            return null;
        }
    }
}
