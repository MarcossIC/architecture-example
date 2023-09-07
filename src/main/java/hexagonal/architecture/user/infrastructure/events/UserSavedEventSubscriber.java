package hexagonal.architecture.user.infrastructure.events;

import hexagonal.architecture.shared.domain.services.email.MailService;
import hexagonal.architecture.user.domain.events.UserSavedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSavedEventSubscriber{
    private final MailService service;
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
