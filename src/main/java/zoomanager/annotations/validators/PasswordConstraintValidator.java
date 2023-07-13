package zoomanager.annotations.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.passay.*;
import zoomanager.annotations.ValidPassword;

import java.io.InputStream;
import java.util.*;

@Slf4j
public record PasswordConstraintValidator()
        implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        Properties props = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("passay.properties");
        try {
            props.load(inputStream);
        } catch(Exception ex) {
            log.error(ex.getMessage());
        }
        MessageResolver resolver = new PropertiesMessageResolver(props);

        PasswordValidator validator = new PasswordValidator(resolver, Arrays.asList(
                new LengthRule(8, 16),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),
                new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false),
                new IllegalSequenceRule(EnglishSequenceData.USQwerty, 5, false),
                new WhitespaceRule()
        ));

        RuleResult result = validator.validate(new PasswordData(password));

        if(result.isValid()) {
            return true;
        }

        List<String> messages = validator.getMessages(result);
        String messageTemplate = String.join(" ", messages);
        constraintValidatorContext
                .buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
