package ro.dragomiralin.subscription.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;


@Data
@Builder
@Document
@RequiredArgsConstructor
@AllArgsConstructor
public class Subscription {
    private String id;
    private String name;
    private String userId;
    private String description;
    private Connection connection;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    @Data
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class Connection {
        private String topic;
        private String url;
    }

}
