package hexagonal.architecture.user.infrastructure;

import hexagonal.architecture.shared.domain.MailPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public record UserSavedEventSubscriber(MailPort mailService) {
    @EventListener
    public void sendEmail(UserSavedEvent event) {
        var message = new StringBuilder()
                .append("Hola ").append(event.getUsername()).append(" espero se encuentre bien")
                .append("\n Gracias por registrarte en nuestro sitio :)")
                .append("\n \n Att Gym");

        mailService.send(event.getEmail(), "Tu usuario ha sido registrado correctamete", message.toString());
    }
}
