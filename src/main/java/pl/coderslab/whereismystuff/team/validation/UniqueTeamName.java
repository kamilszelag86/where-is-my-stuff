package pl.coderslab.whereismystuff.team.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueTeamNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueTeamName {

    String message() default "{invalid.team-name.already-exists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
