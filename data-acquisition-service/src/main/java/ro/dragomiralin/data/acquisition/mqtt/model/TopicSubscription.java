package ro.dragomiralin.data.acquisition.mqtt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class TopicSubscription {
    private String id;
    private String userId;
    private String topic;
    private String clientId;

}
