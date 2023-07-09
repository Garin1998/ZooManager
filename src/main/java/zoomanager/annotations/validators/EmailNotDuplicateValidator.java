package zoomanager.annotations.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import zoomanager.annotations.EmailNotExist;
import zoomanager.jpa.UserRepository;

public record EmailNotDuplicateValidator(
        UserRepository userRepository
) implements ConstraintValidator<EmailNotExist, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByEmail(email).isEmpty();
    }
}
