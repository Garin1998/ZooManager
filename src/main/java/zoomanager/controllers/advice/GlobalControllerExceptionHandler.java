package zoomanager.controllers.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import zoomanager.controllers.advice.errors.GenericErrorDto;
import zoomanager.controllers.advice.errors.MethodArgumentNotValidErrorDto;

import java.util.HashMap;
import java.util.Map;

import static zoomanager.constants.ErrorMessageConstants.MALFORMED_JSON;

@ControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MethodArgumentNotValidErrorDto> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        log.error(String.format("Arguments from request are not valid. Message: %s", errors));
        return ResponseEntity.badRequest().body(new MethodArgumentNotValidErrorDto(errors));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<GenericErrorDto> handleMessageNotReadableExceptions() {
        log.error(MALFORMED_JSON.getMessage());
        return ResponseEntity.badRequest().body(new GenericErrorDto(MALFORMED_JSON.getMessage()));
    }
}
