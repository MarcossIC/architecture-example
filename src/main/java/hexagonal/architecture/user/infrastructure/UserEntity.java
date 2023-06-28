package hexagonal.architecture.user.infrastructure;

import hexagonal.architecture.user.domain.UserModel;
import hexagonal.architecture.user.domain.UserSaveModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;


/**
 * This is an entity in your context
 */
@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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

    public static UserEntity saveModelToEntity(UserSaveModel model) {
        return UserEntity.builder()
                .username(model.getUsername())
                .email(model.getEmail())
                .password(model.getPassword())
                .build();
    }

    public UserModel toModel() {
        return UserModel.builder()
                .id(this.getId().toString())
                .username(this.getUsername())
                .email(this.getEmail())
                .password(this.getPassword())
                .build();
    }
}
