package pl.coderslab.whereismystuff.team.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.whereismystuff.team.entity.JoinTeamRequest;
import pl.coderslab.whereismystuff.team.entity.JoinTeamRequestStatus;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.team.repository.JoinTeamRequestRepository;
import pl.coderslab.whereismystuff.team.repository.TeamRepository;
import pl.coderslab.whereismystuff.user.entity.User;
import pl.coderslab.whereismystuff.user.repository.UserRepository;
import pl.coderslab.whereismystuff.user.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final JoinTeamRequestRepository joinTeamRequestRepository;
    private final UserRepository userRepository;

    @Override
    public Team findByName(String teamName) {
        return teamRepository.findByName(teamName);
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team create(Team team, User user) {
        Team created = teamRepository.save(team);
        user.setTeam(created);
        userRepository.save(user);
        return created;
    }

    @Override
    public void createJoinTeamRequest(Team team, User user) {
        if (user.getJoinTeamRequest() != null) {
            joinTeamRequestRepository.delete(user.getJoinTeamRequest());
        }
        JoinTeamRequest joinTeamRequest = new JoinTeamRequest();
        joinTeamRequest.setTeam(team);
        joinTeamRequest.setUser(user);
        joinTeamRequest.setStatus(JoinTeamRequestStatus.ACTIVE);
        user.setJoinTeamRequest(joinTeamRequestRepository.save(joinTeamRequest));
    }

    @Override
    public void deleteJoinTeamRequest(JoinTeamRequest request) {
        joinTeamRequestRepository.delete(request);
    }

    @Override
    public List<JoinTeamRequest> findAllActiveJoinRequests(Team team) {
        return joinTeamRequestRepository.findAllActiveByTeam(team);
    }

    @Override
    public void approveJoinTeamRequest(JoinTeamRequest request) {
        request.getUser().setTeam(request.getTeam());
        request.setStatus(JoinTeamRequestStatus.APPROVED);
    }

    @Override
    public void rejectJoinTeamRequest(JoinTeamRequest request) {
        request.setStatus(JoinTeamRequestStatus.REJECTED);
    }
}