package ro.dragomiralin.notification.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@RequiredArgsConstructor
@AllArgsConstructor
public class Subscription {
    private String id;
    private String macAddress;
    private String acquisitionType;
    private Operator operator;
    private DeviceType device;
    private double value;
    private boolean sendEmail;
    private boolean sendSMS;
    private String email;
    private String phoneNumber;

    public enum Operator {
        LESS, EQUAL
    }
}