package pl.coderslab.whereismystuff.user.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ConfirmedPasswordValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmedPassword {

    String message() default "{invalid.password-confirmation}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
