package hexagonal.architecture.shared.domain.services.email;

import hexagonal.architecture.shared.domain.util.EmailTemplateStrategy;

import java.io.File;

public interface MailService {
    Boolean send(String to, String subject, String textMessage);

    Boolean send(String to, String subject, String textMessage, File... attachments);

    void setTemplateStrategy(EmailTemplateStrategy strategy);

    String executeTemplate(String... values);
}
