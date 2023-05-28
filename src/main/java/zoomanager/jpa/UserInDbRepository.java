package zoomanager.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zoomanager.models.entities.UserInDb;

import java.util.UUID;

@Repository
public interface UserInDbRepository extends JpaRepository<UserInDb, UUID> {
}