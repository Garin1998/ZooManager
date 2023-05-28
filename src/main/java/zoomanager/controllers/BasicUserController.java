package zoomanager.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zoomanager.handlers.UserInDbRepositoryHandler;
import zoomanager.models.dtos.UserInDbDto;
import zoomanager.models.entities.UserInDb;

@RestController
@RequestMapping("/zoo_manager/user")
@AllArgsConstructor
public class BasicUserController extends UserController {

    private final UserInDbRepositoryHandler userInDbRepositoryHandler;

    @Override
    public UserInDb register(@RequestBody UserInDbDto userInDbDto) {
        return userInDbRepositoryHandler.addUser(userInDbDto);
    }
}
