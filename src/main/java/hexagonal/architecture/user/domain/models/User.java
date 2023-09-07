package hexagonal.architecture.user.domain.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public final class User {
    private String id;
    private String username;
    private String email;
    private String password;
}
