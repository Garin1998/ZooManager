package zoomanager.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthReq(
        @JsonProperty("name")
        String name,
        @JsonProperty("password")
        String password
) {}
