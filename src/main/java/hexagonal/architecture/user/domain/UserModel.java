package hexagonal.architecture.user.domain;

import lombok.Builder;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Builder
@Value
public class UserModel {
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
