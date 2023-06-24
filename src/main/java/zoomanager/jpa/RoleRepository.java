package zoomanager.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import zoomanager.models.ERole;
import zoomanager.models.entities.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByRoleName(ERole name);
}
