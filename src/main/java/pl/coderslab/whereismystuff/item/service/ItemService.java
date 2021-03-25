package pl.coderslab.whereismystuff.item.service;

import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.user.entity.User;

import java.io.IOException;
import java.util.List;

public interface ItemService {

    Item create(Item item);

    List<Item> findAllByUser(User user);

    List<Item> findAllByTeam(Team team);

    List<Item> findAllByLocation(Location location);

    List<Item> findAllByCategory(Category category);

    Item findById(long itemId);

    Item update(Item item);

    void delete(Item item) throws IOException;

    void setItemImage(Item item, MultipartFile multipartFile) throws IOException;

    void setReceiptImage(Item item, MultipartFile multipartFile) throws IOException;

    void setLocation(List<Item> items, Location location);

    boolean existsByLocation(Location location);

    long countByTeam(Team team);

}
