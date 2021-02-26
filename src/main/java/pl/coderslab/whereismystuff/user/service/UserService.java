package pl.coderslab.whereismystuff.user.service;

import pl.coderslab.whereismystuff.user.entity.User;

public interface UserService {

    User findByUserName(String userName);

    void saveUser(User user);

}
