package ro.dragomiralin.data.acquisition.mqtt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Subscribe {
    private String message;
    private Integer qos;
    private Integer id;

}
