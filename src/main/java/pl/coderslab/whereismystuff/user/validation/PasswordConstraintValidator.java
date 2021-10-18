package pl.coderslab.whereismystuff.user.validation;

import lombok.SneakyThrows;
import org.passay.*;
import org.passay.spring.SpringMessageResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void initialize(ValidPassword constraint) {
    }

    @SneakyThrows
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        MessageResolver messageResolver = new SpringMessageResolver(messageSource);
        PasswordValidator validator = new PasswordValidator(messageResolver,
                Arrays.asList(
                        new LengthRule(6, 30),
                        new CharacterRule(PolishCharacterData.UpperCase, 1),
                        new CharacterRule(PolishCharacterData.LowerCase, 1),
                        new CharacterRule(EnglishCharacterData.Digit, 1),
                        new WhitespaceRule()
                ));

        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        List<String> messages = validator.getMessages(result);
        String messageTemplate = String.join(", ", messages);
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
