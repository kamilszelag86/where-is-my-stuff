package pl.coderslab.whereismystuff.user.dto;

import org.springframework.stereotype.Component;
import pl.coderslab.whereismystuff.user.entity.User;

@Component
public class UserDtoConverter {

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }


}
