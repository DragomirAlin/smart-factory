package ro.dragomiralin.notification.service.sms.service.provider;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.dragomiralin.notification.service.sms.service.SMSService;

@Slf4j
@Service
public class TwilloService implements SMSService {
    @Value("${twillo.account-sid}")
    private String accountSID;
    @Value("${twillo.auth-token}")
    private String authToken;
    @Value("${twillo.phone-number}")
    private String phoneNumber;

    @Override
    public void sendSMS(String numberTo, String message) {
        Twilio.init(accountSID, authToken);
        Message.creator(new PhoneNumber(formatNumber(numberTo)), new PhoneNumber(phoneNumber), message).create();
    }

    private String formatNumber(String phoneNumber) {
        return "+40" + phoneNumber;
    }
}
