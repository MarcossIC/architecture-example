package hexagonal.architecture.user.infrastructure;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;


@Getter
@EqualsAndHashCode
@ToString
public final class UserSavedEvent extends ApplicationEvent {
    private final String email;
    private final String username;
    private final String id;


    public UserSavedEvent(Object source, String email, String username, String id) {
        super(source);
        this.email = email;
        this.id = id;
        this.username = username;
    }
}
