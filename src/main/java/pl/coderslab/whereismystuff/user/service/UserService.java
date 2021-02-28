package pl.coderslab.whereismystuff.user.service;

import pl.coderslab.whereismystuff.user.entity.User;

public interface UserService {

    User findByEmail(String email);

    void saveUser(User user);

}
