package zoomanager.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import zoomanager.models.UserRole;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

public record UserInDbDto(
        @JsonProperty("uuid")
        UUID uuid,
        @JsonProperty("name")
        String name,
        @JsonProperty("password")
        String password,
        @JsonProperty("roles")
        Set<UserRole> roles,
        @JsonProperty("timestamp")
        Timestamp registrationTimestamp) {

}
