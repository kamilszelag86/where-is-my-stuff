package pl.coderslab.whereismystuff.location.converter;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.location.service.LocationService;

public class LocationConverter implements Converter<String, Location> {

    private LocationService locationService;

    @Override
    public Location convert(String s) {
        return null;
    }
}
