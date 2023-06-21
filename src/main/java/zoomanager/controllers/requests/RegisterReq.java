package zoomanager.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.naming.factory.SendMailFactory;

public record RegisterReq(
        @JsonProperty("name")
        String name,
        @JsonProperty("password")
        String password,
        @JsonProperty("firstname")
        String firstName,
        @JsonProperty("lastname")
        String lastName,
        @JsonProperty("email")
        String email
) {}
