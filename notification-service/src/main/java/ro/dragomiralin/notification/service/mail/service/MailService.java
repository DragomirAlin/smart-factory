package ro.dragomiralin.notification.service.mail.service;


import ro.dragomiralin.notification.service.mail.dto.Mail;

public interface MailService {
    void sendMail(Mail mail);
}
