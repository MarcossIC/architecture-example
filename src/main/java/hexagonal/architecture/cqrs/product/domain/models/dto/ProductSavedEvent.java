package hexagonal.architecture.cqrs.product.domain.models.dto;

import hexagonal.architecture.shared.domain.util.EmailTemplateStrategy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;


@Getter
@EqualsAndHashCode
@ToString
public final class ProductSavedEvent extends ApplicationEvent {
    private final String username;
    private final String email;
    private final EmailTemplateStrategy strategy;


    public ProductSavedEvent(Object source, EmailTemplateStrategy strategy, String username, String email) {
        super(source);
        this.username = username;
        this.email = email;
        this.strategy = strategy;
    }
}
