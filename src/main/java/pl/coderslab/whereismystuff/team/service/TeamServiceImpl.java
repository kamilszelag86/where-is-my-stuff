package pl.coderslab.whereismystuff.team.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.whereismystuff.team.entity.JoinTeamRequest;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.team.repository.JoinTeamRequestRepository;
import pl.coderslab.whereismystuff.team.repository.TeamRepository;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final JoinTeamRequestRepository joinTeamRequestRepository;

    @Override
    public Team findByName(String teamName) {
        return teamRepository.findByName(teamName);
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team create(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void createJoinTeamRequest(Team team, User user) {
        if (user.getJoinTeamRequest() != null) {
            joinTeamRequestRepository.delete(user.getJoinTeamRequest());
        }
        JoinTeamRequest joinTeamRequest = new JoinTeamRequest();
        joinTeamRequest.setTeam(team);
        joinTeamRequest.setUser(user);
        joinTeamRequest.setActive(true);
        user.setJoinTeamRequest(joinTeamRequestRepository.save(joinTeamRequest));
    }

    @Override
    public void deleteJoinTeamRequest(JoinTeamRequest request) {
        joinTeamRequestRepository.delete(request);
    }

    @Override
    public List<JoinTeamRequest> findAllActiveJoinRequests(Team team) {
        return joinTeamRequestRepository.findAllByTeamAndActiveIsTrue(team);
    }

    @Override
    public void approveJoinTeamRequest(JoinTeamRequest request) {
        request.getUser().setTeam(request.getTeam());
        request.setApproved(true);
        request.setActive(false);
    }

    @Override
    public void rejectJoinTeamRequest(JoinTeamRequest request) {
        request.setRejected(true);
        request.setActive(false);
    }
}