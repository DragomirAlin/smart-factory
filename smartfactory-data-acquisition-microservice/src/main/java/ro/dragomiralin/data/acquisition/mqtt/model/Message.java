package ro.dragomiralin.data.acquisition.mqtt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Message {
    private String topic;
    private String message;
    private Boolean retained;
    private Integer qos;
}
