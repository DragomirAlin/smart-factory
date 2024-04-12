package ro.dragomiralin.notification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ro.dragomiralin.notification.service.NotificationService;
import ro.dragomiralin.notification.service.mail.dto.Mail;
import ro.dragomiralin.notification.service.sms.model.SMS;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController implements SecuredRestController{
    private final NotificationService notificationService;

    @GetMapping
    public String test() {
        return "Notification Service";
    }

    @PostMapping("/mail")
    public void sendMail(@AuthenticationPrincipal Jwt jwt, @RequestBody Mail mail) {
        notificationService.sendMail(mail);
    }

    @PostMapping("/sms")
    public void sendSMS(@AuthenticationPrincipal Jwt jwt, @RequestBody SMS sms) {
        notificationService.sendSMS(sms);
    }


}
