package zoomanager.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import zoomanager.annotations.validators.UserNameNotDuplicateValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UserNameNotDuplicateValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface UserNameNotExist {

    String message() default "User with provided name already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
