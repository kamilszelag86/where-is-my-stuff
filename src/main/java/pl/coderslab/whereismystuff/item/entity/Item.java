package pl.coderslab.whereismystuff.item.entity;

import lombok.Data;
import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.location.entity.Location;
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
    private long id;

    @NotBlank
    private String name;

    private String description;

    @ManyToOne
    @NotNull
    private User user;

    @OneToOne
    private Location location;

    @ManyToMany
    private List<Category> categories;


}
