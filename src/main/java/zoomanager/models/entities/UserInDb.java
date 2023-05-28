package zoomanager.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user_in_db")
@NoArgsConstructor
@Getter
@Setter
public class UserInDb {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "uuid")
    private UUID userUuid;

    @Column(name = "name")
    private String userName;

    @Column(name = "password")
    private String userPassword;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> userRoles = new HashSet<>();

    @Column(name = "registration_timestamp")
    @CreationTimestamp
    private Timestamp userRegistrationTimestamp;

}
