package hexagonal.architecture.shared.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@RequiredArgsConstructor
public class ApplicationBeansConfig {

    /**
     * Configura el Bean de JavaMailSender
     */
    @Bean
    public JavaMailSenderImpl javaMailSender() {
        var sender = new JavaMailSenderImpl();
        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        //Pass: Primefit1234
        sender.setUsername("gymprimefitnes@gmail.com");
        sender.setPassword("pgwltsgzkgbonmmr");

        var props = sender.getJavaMailProperties();

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.ssl.trust", "*");
        return sender;
    }

    @Bean
    public ApplicationEventMulticaster applicationEventMulticaster() {
        var simpleEventMulticaster = new SimpleApplicationEventMulticaster();
        simpleEventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return simpleEventMulticaster;
    }
}
