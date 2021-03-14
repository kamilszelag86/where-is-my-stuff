package pl.coderslab.whereismystuff.user.dto;

import pl.coderslab.whereismystuff.user.entity.User;

public class UserDtoConverter {

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }


}
