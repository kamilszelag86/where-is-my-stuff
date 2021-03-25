package pl.coderslab.whereismystuff.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.whereismystuff.team.entity.Team;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByName(String teamName);

}
