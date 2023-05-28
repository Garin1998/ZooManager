package zoomanager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import zoomanager.models.dtos.UserInDbDto;
import zoomanager.models.entities.UserInDb;

public abstract class UserController {

    @GetMapping("/registration")
    public abstract UserInDb register(UserInDbDto userInDbDto);

}
