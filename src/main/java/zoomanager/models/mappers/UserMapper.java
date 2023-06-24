package zoomanager.models.mappers;

import zoomanager.models.dtos.UserDto;
import zoomanager.models.entities.User;

public interface UserMapper {
    User dtoToEntity(UserDto dto);
    UserDto entityToDto(User entity);
}
