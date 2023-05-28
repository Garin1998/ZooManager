package zoomanager.handlers;

import zoomanager.models.dtos.UserInDbDto;
import zoomanager.models.entities.UserInDb;

public interface UserInDbRepositoryHandler {

    UserInDb addUser(UserInDbDto userDto);

}
