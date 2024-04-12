package ro.dragomiralin.notification.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ro.dragomiralin.notification.service.NotificationService;
import ro.dragomiralin.notification.service.mail.dto.Mail;
import ro.dragomiralin.notification.service.mail.service.MailService;
import ro.dragomiralin.notification.service.sms.model.SMS;
import ro.dragomiralin.notification.service.sms.service.SMSService;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final MailService mailService;
    private final SMSService smsService;

    @Async
    @Override
    public void sendMail(Mail mail) {
        try {
            mailService.sendMail(mail);
            log.info("An email has been sent to {}", mail.getMailTo());
        } catch (Exception e) {
            log.error("There was a problem sending the email, more details: {}", e.getMessage());
        }
    }

    @Async
    @Override
    public void sendSMS(SMS sms) {
        try {
            smsService.sendSMS(sms.getNumberTo(), sms.getMessage());
            log.info("An sms has been sent to {}", sms.getNumberTo());
        } catch (Exception e) {
            log.error("There was a problem sending sms, more details: {}", e.getMessage());
        }
    }
}
