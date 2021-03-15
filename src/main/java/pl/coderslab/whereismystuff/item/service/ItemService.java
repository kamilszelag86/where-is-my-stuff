package pl.coderslab.whereismystuff.item.service;

import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface ItemService {

    void create(Item item);

    List<Item> findAllByTeam(Team team);

    Item findById(long itemId);

    void update(Item item);

    void delete(long itemId);
}
