package zoomanager.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;
import java.util.StringJoiner;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_in_db")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_uuid"),
            inverseJoinColumns = @JoinColumn(name = "role_uuid"))
    private  Set<Role> userRoles;
    @CreationTimestamp
    private Timestamp registrationTimestamp;

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ",getClass().getSimpleName() + "(",")");
        return sj
                .add("uuid = " + uuid)
                .add("name = " + name)
                .add("password = ***")
                .add("firstName = ***")
                .add("lastName = ***")
                .add("email = ***")
                .add("roles = " + userRoles)
                .add("registrationTimestamp = " + registrationTimestamp)
                .toString();
    }
}
