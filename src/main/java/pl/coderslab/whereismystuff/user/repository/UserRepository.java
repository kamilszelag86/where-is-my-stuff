package pl.coderslab.whereismystuff.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAllByTeam(Team team);

}
