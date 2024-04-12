package ro.dragomiralin.notification.service.sms.service;


public interface SMSService {
    void sendSMS(String numberTo, String message);
}
