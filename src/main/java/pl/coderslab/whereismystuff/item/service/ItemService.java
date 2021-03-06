package pl.coderslab.whereismystuff.item.service;

import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface ItemService {

    void save(Item item);

    List<Item> findAllByUser(User user);

}
