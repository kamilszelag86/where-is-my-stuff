package pl.coderslab.whereismystuff.category.entity;

import lombok.Data;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Category.TABLE_NAME)
@Data
public class Category {

    public static final String TABLE_NAME = "categories";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String description;

    @ManyToOne
    @NotNull
    private User user;

}
