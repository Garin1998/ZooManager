package zoomanager.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zoomanager.models.UserRole;

import java.util.UUID;

@Entity
@Table(name = "role")
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID roleUuid;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private UserRole roleName;

}
