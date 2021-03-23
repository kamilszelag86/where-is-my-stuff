package pl.coderslab.whereismystuff.user.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.SetUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.whereismystuff.security.RoleRepository;
import pl.coderslab.whereismystuff.team.entity.JoinTeamRequest;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;
import pl.coderslab.whereismystuff.user.repository.UserRepository;

import javax.persistence.criteria.Join;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRoles(SetUtils.hashSet(roleRepository.getRoleUser()));
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.save(user);
        }
    }

    @Override
    public void setTeamForUser(Team team, User user) {
        user.setTeam(team);
        updateUser(user);
    }

    @Override
    public List<User> findAllByTeam(Team team) {
        return userRepository.findAllByTeam(team);
    }
}
