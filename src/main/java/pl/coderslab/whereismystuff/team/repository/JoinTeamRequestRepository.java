package pl.coderslab.whereismystuff.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.whereismystuff.team.entity.JoinTeamRequest;
import pl.coderslab.whereismystuff.team.entity.Team;

import java.util.List;

public interface JoinTeamRequestRepository extends JpaRepository<JoinTeamRequest, Long> {

    @Query("select j from JoinTeamRequest j where j.team = :team and j.status = pl.coderslab.whereismystuff.team.entity.JoinTeamRequestStatus.ACTIVE")
    List<JoinTeamRequest> findAllActiveByTeam(Team team);

}
