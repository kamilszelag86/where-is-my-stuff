package pl.coderslab.whereismystuff.item.service;

import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    void create(Item item);

    List<Item> findAllByUser(User user);

    Optional<Item> findById(long itemId);

    void update(Item item);

    void delete(long itemId);
}
