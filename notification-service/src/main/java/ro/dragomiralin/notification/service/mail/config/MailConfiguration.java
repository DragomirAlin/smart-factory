package ro.dragomiralin.notification.service.mail.config;

import com.hubspot.jinjava.Jinjava;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@Configuration
@RequiredArgsConstructor
public class MailConfiguration {
    @Value("${spring.mail.host}")
    private String hostMail;
    @Value("${spring.mail.port}")
    private Integer portMail;
    @Value("${spring.mail.username}")
    private String usernameMail;
    @Value("${spring.mail.password}")
    private String passwordEmail;

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(hostMail);
        mailSender.setPort(portMail);
        mailSender.setUsername(usernameMail);
        mailSender.setPassword(passwordEmail);

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

    @Bean
    public Jinjava getJinja() {
        return new Jinjava();
    }
}
