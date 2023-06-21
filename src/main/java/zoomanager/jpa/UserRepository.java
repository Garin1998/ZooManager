package zoomanager.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import zoomanager.models.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
}
