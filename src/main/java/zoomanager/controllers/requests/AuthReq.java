package zoomanager.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record AuthReq(
        @JsonProperty("name")
        @NotBlank(message = "Must be filled")
        String name,
        @JsonProperty("password")
        @NotBlank(message = "Must be filled")
        String password
) {}
