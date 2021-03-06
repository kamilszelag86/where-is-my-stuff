package pl.coderslab.whereismystuff.user.entity;

import lombok.Data;
import pl.coderslab.whereismystuff.security.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
@Data
public class User {

    public static final String TABLE_NAME = "users";
    public static final int ENABLED = 1;
    public static final int DISABLED = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @NotBlank
    private String firstName;
    //    @NotBlank
    private String lastName;
    @Column(nullable = false, unique = true, length = 60)
//    @NotBlank
//    @UniqueUsername
    private String username;
    //    @NotBlank
    private String password;
    private boolean enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
