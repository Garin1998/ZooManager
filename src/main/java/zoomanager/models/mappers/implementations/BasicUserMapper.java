package zoomanager.models.mappers.implementations;

import org.springframework.stereotype.Component;
import zoomanager.models.dtos.UserDto;
import zoomanager.models.entities.User;
import zoomanager.models.mappers.UserMapper;

@Component
public class BasicUserMapper implements UserMapper {

    @Override
    public User dtoToEntity(UserDto dto) {
        return User.builder()
                .uuid(dto.uuid())
                .name(dto.name())
                .password(dto.password())
                .email(dto.email())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .userRoles(dto.roles())
                .registrationTimestamp(dto.registrationTimestamp())
                .build();
    }

    @Override
    public UserDto entityToDto(User entity) {
        return new UserDto(
                entity.getUuid(),
                entity.getName(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getUserRoles(),
                entity.getRegistrationTimestamp()
        );
    }
}
