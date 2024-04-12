package ro.dragomiralin.notification.service;

import ro.dragomiralin.notification.service.mail.dto.Mail;
import ro.dragomiralin.notification.service.sms.model.SMS;

public interface NotificationService {
    void sendMail(Mail mail);
    void sendSMS(SMS sms);
}
