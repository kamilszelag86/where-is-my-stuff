package pl.coderslab.whereismystuff.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByUser(User user);
}
