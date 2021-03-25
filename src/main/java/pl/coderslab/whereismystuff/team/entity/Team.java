package pl.coderslab.whereismystuff.team.entity;

import lombok.Data;
import pl.coderslab.whereismystuff.team.validation.UniqueTeamName;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
