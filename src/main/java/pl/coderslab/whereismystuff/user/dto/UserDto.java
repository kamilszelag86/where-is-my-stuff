package pl.coderslab.whereismystuff.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.whereismystuff.user.validation.ConfirmedPassword;
import pl.coderslab.whereismystuff.user.validation.UniqueUsername;

import javax.validation.constraints.NotBlank;

@ConfirmedPassword
@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @UniqueUsername
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;

}
