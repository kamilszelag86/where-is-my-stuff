package pl.coderslab.whereismystuff.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.whereismystuff.team.entity.JoinTeamRequest;

public interface JoinTeamRequestRepository extends JpaRepository<JoinTeamRequest, Long> {

}
