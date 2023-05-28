package zoomanager.models.dtos.mappers.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zoomanager.jpa.RoleRepository;
import zoomanager.models.UserRole;
import zoomanager.models.dtos.UserInDbDto;
import zoomanager.models.dtos.mappers.UserInDbMapper;
import zoomanager.models.entities.Role;
import zoomanager.models.entities.UserInDb;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class BaseUserInDbMapper implements UserInDbMapper {

    private final RoleRepository roleRepository;

    static String roleNotFound = "Error: Role is not found.";

    @Override
    public UserInDb userInDbDtoToUserInDbEntity(UserInDbDto userInDbDto) {

        UserInDb userInDb = new UserInDb();

        userInDb.setUserUuid(userInDbDto.uuid());
        userInDb.setUserName(userInDbDto.name());
        userInDb.setUserPassword(userInDbDto.password());
        userInDb.setUserRegistrationTimestamp(userInDbDto.registrationTimestamp());

        Set<UserRole> rolesFromDto = userInDbDto.roles();
        Set<Role> roles = new HashSet<>();

        if(rolesFromDto == null) {
            Role userRole = roleRepository.findByRoleName(UserRole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException(roleNotFound));
            roles.add(userRole);
        }
        else {
            rolesFromDto.forEach(role -> {
                switch (role.getName()) {
                    case "admin" -> {
                        Role adminRole = roleRepository.findByRoleName(UserRole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException(roleNotFound));
                        roles.add(adminRole);
                    }
                    default -> {
                        Role userRole = roleRepository.findByRoleName(UserRole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException(roleNotFound));
                        roles.add(userRole);
                    }
                }
            });
        }


        userInDb.setUserRoles(roles);

        return userInDb;
    }

    @Override
    public UserInDbDto UserInDbEntityToUserInDbDto(UserInDb userInDb) {
        return null;
    }
}
