package hexagonal.architecture.user.domain.events;

import hexagonal.architecture.shared.domain.util.EmailTemplateStrategy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;


@Getter
@EqualsAndHashCode
@ToString
public final class UserSavedEvent extends ApplicationEvent {
    private final String username;
    private final String email;
    private final EmailTemplateStrategy strategy;


    public UserSavedEvent(Object source, EmailTemplateStrategy strategy, String username, String email) {
        super(source);
        this.username = username;
        this.email = email;
        this.strategy = strategy;
    }
}
