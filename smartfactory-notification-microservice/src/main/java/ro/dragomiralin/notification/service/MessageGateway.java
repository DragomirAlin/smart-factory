package ro.dragomiralin.notification.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ro.dragomiralin.notification.common.Subscription;
import ro.dragomiralin.notification.service.mail.dto.Mail;
import ro.dragomiralin.notification.service.sms.model.SMS;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageGateway {
    private final NotificationService notificationService;

    public void handle(Subscription monitor) {
        if (monitor.isSendEmail()) this.handleMail(monitor);
        if (monitor.isSendSMS()) this.handleSMS(monitor);
    }

    private void handleSMS(Subscription monitor) {
        var message = "Hello, check your board. A new alert has appeared.";

        var smsMessage = SMS.builder()
                .numberTo(monitor.getPhoneNumber())
                .message(message)
                .build();

        notificationService.sendSMS(smsMessage);
    }

    private void handleMail(Subscription subscription) {
        var message = "Hello, check your board. A new alert has appeared.";

        var mail = Mail.builder()
                .mailTo(subscription.getEmail())
                .mailSubject("Notification")
                .contentType(message)
                .build();

        notificationService.sendMail(mail);
    }

    private void handleWhatsapp() {

    }
// TODO: add client
}
