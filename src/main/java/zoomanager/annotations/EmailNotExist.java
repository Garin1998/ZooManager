package zoomanager.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import zoomanager.annotations.validators.EmailNotDuplicateValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = EmailNotDuplicateValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface EmailNotExist {

    String message() default "User with provided email already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
