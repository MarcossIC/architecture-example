package hexagonal.architecture.shared.infrastructure;

import hexagonal.architecture.shared.domain.MailPort;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

@Service
@Getter
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JavaMailServiceAdapt implements MailPort {
    private static final File[] NO_ATTACHMENTS = null;

    private final JavaMailSender sender;

    /**
     * Configuracion del sender
     */
    @Value("${spring.mail.username}")
    private String from;

    @Override
    public Boolean send(String to, String subject, String textMessage) {
        return this.send(to, subject, textMessage, NO_ATTACHMENTS);
    }

    @Override
    public Boolean send(String to, String subject, String textMessage, File... attachments) {
        var send = false;
        Assert.hasLength(to, "email 'to' needed");
        Assert.hasLength(subject, "email 'subject' needed");
        Assert.hasLength(textMessage, "email 'text' needed");
        log.info("3 to: {}", to);
        log.info("3 from: {}", this.getFrom());
        log.info("3 subject: {}", subject);
        log.info("3 message: {}", textMessage);
        log.info("sender: {}", this.sender.toString());
        final MimeMessage message = sender.createMimeMessage();
        try {
            // el flag a true indica que va a ser multipart
            final MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // settings de los parámetros del envío
            helper.setFrom(this.getFrom());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(textMessage);
            // adjuntando los ficheros
            if (attachments != null) preparingAttachment(Arrays.stream(attachments), helper);
            this.sender.send(message);
            send = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return send;
    }

    private void preparingAttachment(Stream<File> attachments, MimeMessageHelper helper){
        attachments.forEach(attachment -> {
            try {
                FileSystemResource file = new FileSystemResource(attachment);
                helper.addAttachment(attachment.getName(), file);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
    }

}