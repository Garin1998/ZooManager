package zoomanager.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import zoomanager.annotations.EmailNotExist;
import zoomanager.annotations.UserNameNotExist;
import zoomanager.annotations.ValidPassword;

@Builder
public record RegisterReq(
        @JsonProperty("name")
        @NotBlank(message = "Must be filled")
        @UserNameNotExist
        String name,
        @JsonProperty("password")
        @ValidPassword
        String password,
        @JsonProperty("firstName")
        @NotBlank(message = "Must be filled")
        String firstName,
        @JsonProperty("lastName")
        @NotBlank(message = "Must be filled")
        String lastName,
        @JsonProperty("email")
        @NotBlank(message = "Must be filled")
        @Email(message = "Must be valid email")
        @EmailNotExist
        String email
) {}
