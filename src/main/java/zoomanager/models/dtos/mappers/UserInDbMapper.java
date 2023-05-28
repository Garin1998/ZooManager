package zoomanager.models.dtos.mappers;

import zoomanager.models.dtos.UserInDbDto;
import zoomanager.models.entities.UserInDb;

public interface UserInDbMapper {

    UserInDb userInDbDtoToUserInDbEntity(UserInDbDto userInDbDto);
    UserInDbDto UserInDbEntityToUserInDbDto(UserInDb userInDb);
}
