package hexagonal.architecture.user.application.output.email;

import hexagonal.architecture.shared.domain.TemplateStrategy;
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
    private final TemplateStrategy strategy;


    public UserSavedEvent(Object source, TemplateStrategy strategy, String username, String email) {
        super(source);
        this.username = username;
        this.email = email;
        this.strategy = strategy;
    }
}
