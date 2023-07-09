package zoomanager.controllers.advice.errors;

import java.util.Map;

public record MethodArgumentNotValidErrorDto(
        Map<String, String> message
) {}
