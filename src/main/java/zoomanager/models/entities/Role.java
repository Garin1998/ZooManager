package zoomanager.models.entities;

import jakarta.persistence.*;
import lombok.*;
import zoomanager.models.ERole;

import java.util.StringJoiner;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private ERole name;

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ",getClass().getSimpleName() + "(",")");
        return sj
                .add("uuid = " + uuid)
                .add("name = " + name)
                .toString();
    }
}
