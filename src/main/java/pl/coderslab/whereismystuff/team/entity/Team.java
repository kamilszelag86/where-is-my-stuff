package pl.coderslab.whereismystuff.team.entity;

import lombok.Data;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = Team.TABLE_NAME)
@Data
public class Team {

    public static final String TABLE_NAME = "teams";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

//    @OneToMany(mappedBy = "team")
//    private Set<User> members;

}
