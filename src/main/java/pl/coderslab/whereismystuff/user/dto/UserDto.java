package pl.coderslab.whereismystuff.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.whereismystuff.user.validation.ConfirmedPassword;
import pl.coderslab.whereismystuff.user.validation.UniqueUsername;
import pl.coderslab.whereismystuff.user.validation.ValidPassword;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @Size(max = 60)
    private String username;
    @NotBlank
    @ValidPassword
    private String password;
    @NotBlank
    private String confirmPassword;

}
