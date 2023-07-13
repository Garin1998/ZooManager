package zoomanager.constants;

import lombok.Getter;

@Getter
public enum ErrorMessageConstants {
    MALFORMED_JSON("Malformed JSON in request."),
    ARGS_NOT_VALID("Arguments from request are not valid."),
    MUST_BE_FILLED("Must be filled");

    private final String message;
    
    ErrorMessageConstants(String message) {
        this.message = message;
    }
}
