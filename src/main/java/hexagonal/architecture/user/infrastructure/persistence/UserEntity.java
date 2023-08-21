package hexagonal.architecture.user.infrastructure.persistence;

import hexagonal.architecture.user.domain.model.User;
import hexagonal.architecture.user.domain.model.dto.UserSaveDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 30, nullable = false)
    private String username;

    @Column(name = "email", length = 128, nullable = false)
    private String email;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    public static UserEntity saveModelToEntity(UserSaveDTO model) {
        return UserEntity.builder()
                .username(model.getUsername())
                .email(model.getEmail())
                .password(model.getPassword())
                .build();
    }

    public User toModel() {
        return User.builder()
                .id(this.getId().toString())
                .username(this.getUsername())
                .email(this.getEmail())
                .password(this.getPassword())
                .build();
    }
}
