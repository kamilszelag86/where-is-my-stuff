package pl.coderslab.whereismystuff.team.entity;

import lombok.Data;
import org.springframework.security.access.prepost.PreFilter;
import pl.coderslab.whereismystuff.team.validation.UniqueTeamName;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = Team.TABLE_NAME)
@Data
public class Team {

    public static final String TABLE_NAME = "teams";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @UniqueTeamName
    private String name;

}
