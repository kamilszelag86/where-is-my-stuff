package pl.coderslab.whereismystuff.item.entity;

import lombok.Data;
import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = Item.TABLE_NAME)
@Data
public class Item {

    public static final String TABLE_NAME = "items";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String description;
    private String itemImage;
    private String receiptImage;

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private Team team;

    @ManyToOne
    private Location location;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;

    public String getItemImagePath() {
        if (itemImage == null || itemImage.isBlank() || id == null) {
            return null;
        }
        return "/item-images/" + id + "/" + itemImage;
    }

    public String getReceiptImagePath() {
        if (receiptImage == null || receiptImage.isBlank() || id == null) {
            return null;
        }
        return "/item-images/" + id + "/" + receiptImage;
    }

}
