package pl.coderslab.whereismystuff.team.entity;

import lombok.Data;
import org.springframework.security.access.prepost.PreFilter;
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
    private String name;

//    @OneToMany(mappedBy = "team")
//    private Set<User> members;

    @OneToMany(mappedBy = "team")
    private List<JoinTeamRequest> joinTeamRequests;

    @Transient
    private boolean haveActiveRequests = checkActiveRequests();

    private boolean checkActiveRequests() {
        if (joinTeamRequests != null) {
            return joinTeamRequests.stream().anyMatch(JoinTeamRequest::isActive);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", haveActiveRequests=" + haveActiveRequests +
                '}';
    }
}
