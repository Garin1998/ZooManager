package zoomanager.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@Getter
public enum UserRole {

    ROLE_USER("user"),
    ROLE_ADMIN("admin");

    private static final Map<String, UserRole> FORMAT_MAP = Stream
            .of(UserRole.values())
            .collect(Collectors.toMap(s -> s.name, Function.identity()));
    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    @JsonCreator
    public static UserRole fromString(String string) {
        return Optional
                .ofNullable(FORMAT_MAP.get(string))
                .orElseThrow(() -> new IllegalArgumentException(string));
    }
}
