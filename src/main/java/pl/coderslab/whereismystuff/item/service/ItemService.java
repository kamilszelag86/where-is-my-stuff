package pl.coderslab.whereismystuff.item.service;

import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface ItemService {

    void create(Item item);

    List<Item> findAllByUser(User user);

    List<Item> findAllByLocation(Location location);

    Item findById(long itemId);

    void update(Item item);

    void delete(long itemId);
}
