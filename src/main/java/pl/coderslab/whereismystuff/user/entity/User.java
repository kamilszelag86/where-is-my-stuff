package pl.coderslab.whereismystuff.user.entity;

import lombok.Data;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.security.entity.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
@Data
public class User {

    public static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    private String password;
    private boolean enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ManyToOne
    private Team team;

}
