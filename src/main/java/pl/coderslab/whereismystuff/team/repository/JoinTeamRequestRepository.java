package pl.coderslab.whereismystuff.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.whereismystuff.team.entity.JoinTeamRequest;
import pl.coderslab.whereismystuff.team.entity.Team;

import java.util.List;

public interface JoinTeamRequestRepository extends JpaRepository<JoinTeamRequest, Long> {

    List<JoinTeamRequest> findAllByTeamAndActiveIsTrue(Team team);

}
