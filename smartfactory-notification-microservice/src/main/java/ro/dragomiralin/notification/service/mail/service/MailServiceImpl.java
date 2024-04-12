package ro.dragomiralin.notification.service.mail.service;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ro.dragomiralin.notification.service.mail.dto.Mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    @Value("${smartfactory.emailFrom}")
    private String emailFrom;
    private final JavaMailSender mailSender;
    private final Jinjava jinjava;

    @SneakyThrows
    public void sendMail(Mail mail) {
        var mimeMessage = this.createMail(mail);
        mailSender.send(mimeMessage);
    }


    public MimeMessage createMail(Mail mail) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        String contentEmail = getTemplate(mail.getMailContent());

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject(mail.getMailSubject());
        mimeMessageHelper.setFrom(emailFrom);
        mimeMessageHelper.setTo(mail.getMailTo());
        mimeMessageHelper.setText(contentEmail, true);

        return mimeMessageHelper.getMimeMessage();
    }

    public String getTemplate(String content) {
        Map<String, Object> context = Map.of("content", content);
        try {
            var template = Resources.toString(Resources.getResource("emailTemplate.html"), Charsets.UTF_8);
            return jinjava.render(template, context);
        } catch (Exception e) {
            log.error("An error occurred while rendering the mail template. Details = {}.", e.getMessage());
            return content;
        }
    }
}
