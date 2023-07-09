package zoomanager.annotations.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import zoomanager.jpa.UserRepository;
import zoomanager.annotations.UserNameNotExist;

public record UserNameNotDuplicateValidator(
        UserRepository userRepository
) implements ConstraintValidator<UserNameNotExist, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByName(name).isEmpty();
    }
}
