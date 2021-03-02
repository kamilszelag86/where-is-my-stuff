package pl.coderslab.whereismystuff.user.validation;

import pl.coderslab.whereismystuff.user.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmedPasswordValidator implements ConstraintValidator<ConfirmedPassword, UserDto> {
    public void initialize(ConfirmedPassword constraint) {
    }

    public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
        return userDto.getPassword().equals(userDto.getConfirmPassword());
    }
}
