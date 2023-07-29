package hexagonal.architecture.cqrs.user.domain.model;

import hexagonal.architecture.shared.domain.query.Response;
import lombok.Builder;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Builder
public class User implements Response {
    @NotEmpty
    String id;

    @NotEmpty
    @Length(min = 3, max = 30)
    String username;

    @Email
    @Length(max = 128)
    String email;

    @NotEmpty
    @Length(min = 3, max = 20)
    String password;
}
