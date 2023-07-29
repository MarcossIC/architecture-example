package hexagonal.architecture.user.application.input.dto;

import lombok.Builder;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Builder
@Value
public class UserSaveDTO {
    @NotEmpty
    @Length(min = 3, max = 30)
    String username;

    @Email
    @Length(max = 126)
    String email;

    @NotEmpty
    @Length(min = 3, max = 30)
    String password;
}
