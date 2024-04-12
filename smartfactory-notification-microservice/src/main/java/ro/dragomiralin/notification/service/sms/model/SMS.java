package ro.dragomiralin.notification.service.sms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SMS {
    private String numberTo;
    private String message;
}
