package ro.dragomialin.monitor.common;

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
    private AcqusitionType acquisitionType;
    private DeviceType device;
    private Object customMonitor;
    private NotificationDetails notificationDetails;

    public enum Operator {
        LESS, EQUALTO, GREATHER, None
    }

    @Data
    @Builder
    public static class NotificationDetails {
        private boolean sendEmail;
        private boolean sendSMS;
        private String email;
        private String phoneNumber;

    }

    @Data
    @Builder
    public static class Dth22 {
        private double temperatureValue;
        private Operator temperatureOperator;
        private double humidityValue;
        private Operator humidityOperator;

    }

    @Data
    @Builder
    public static class Mq135 {
        private double value;
        private Operator operator;
    }

    @Data
    @Builder
    public static class GoogleMini {
        private String message;
    }
}
