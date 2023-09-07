package hexagonal.architecture.user.infrastructure.persistence;

import hexagonal.architecture.user.domain.models.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user", schema = "example")
@Builder
@Data
public class UserEntity implements Serializable {

    @Id
    @Column(name = "id", columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 40, nullable = false)
    private String username;

    @Column(name = "email", length = 128, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 40, nullable = false, unique = true)
    private String password;

    public static UserEntity modelToEntity(User model) {
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
