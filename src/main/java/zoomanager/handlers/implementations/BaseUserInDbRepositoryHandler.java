package zoomanager.handlers.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zoomanager.handlers.UserInDbRepositoryHandler;
import zoomanager.jpa.UserInDbRepository;
import zoomanager.models.dtos.UserInDbDto;
import zoomanager.models.dtos.mappers.UserInDbMapper;
import zoomanager.models.entities.UserInDb;

@Service
@AllArgsConstructor
public class BaseUserInDbRepositoryHandler implements UserInDbRepositoryHandler {

    private final UserInDbRepository userInDbRepository;
    private final UserInDbMapper userInDbMapper;

    @Override
    public UserInDb addUser(UserInDbDto userInDbDto) {
        return userInDbRepository.save(userInDbMapper.userInDbDtoToUserInDbEntity(userInDbDto));
    }

}