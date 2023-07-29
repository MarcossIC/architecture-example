package hexagonal.architecture.cqrs.user.application.output.email;

import hexagonal.architecture.shared.domain.MailService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public record UserSavedEventSubscriber(MailService service) {

    @Async
    @EventListener
    public void userCreated(UserSavedEvent event) {
        this.service.setTemplateStrategy(event.getStrategy());
        this.service.send(
                event.getEmail(),
                "Se ha creado su cuenta en PrimeFit",
                service.executeTemplate(event.getUsername())
        );
    }
}
