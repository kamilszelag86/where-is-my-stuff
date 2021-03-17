package pl.coderslab.whereismystuff.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByTeam(Team team);

    List<Item> findAllByUser(User user);


    List<Item> findAllByLocation(Location location);


    @Modifying
    @Query("update Item i set i.itemImage = :fileName where i = :item")
    void setItemImage(Item item, String fileName);

    @Modifying
    @Query("update Item i set i.receiptImage = :fileName where i = :item")
    void setReceiptImage(Item item, String fileName);

}
