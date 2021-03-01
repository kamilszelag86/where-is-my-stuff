package pl.coderslab.whereismystuff.user.service;

import pl.coderslab.whereismystuff.user.entity.User;

public interface UserService {

    User findByUsername(String username);

    void saveUser(User user);

}
