package pl.coderslab.whereismystuff.team.entity;

import lombok.Data;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = JoinTeamRequest.TABLE_NAME)
@Data
public class JoinTeamRequest {

    public static final String TABLE_NAME = "join_team_requests";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @ManyToOne
    private Team team;

    private boolean approved;

    private boolean rejected;

    private boolean active;

}
