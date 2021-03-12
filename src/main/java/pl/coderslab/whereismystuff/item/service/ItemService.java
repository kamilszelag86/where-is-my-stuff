package pl.coderslab.whereismystuff.item.service;

import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface ItemService {

    Item create(Item item);

    List<Item> findAllByUser(User user);

    Item findById(long itemId);

    void update(Item item);

    void delete(long itemId);
}
