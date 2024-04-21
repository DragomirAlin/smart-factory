package ro.dragomiralin.subscriptionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO {
    private String id;
    private String name;
    private String userId;
    private String description;
    private Connection connection;

    @Data
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class Connection {
        private String topic;
        private String url;
    }

}
