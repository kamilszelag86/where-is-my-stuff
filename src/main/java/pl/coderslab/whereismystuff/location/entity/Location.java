package pl.coderslab.whereismystuff.location.entity;

import lombok.Data;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Location.TABLE_NAME)
@Data
public class Location {

    public static final String TABLE_NAME = "locations";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String description;

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private Team team;

}
