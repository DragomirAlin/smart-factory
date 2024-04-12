package ro.dragomiralin.data.acquisition.common.sensors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mq2 {
    private double gasValue;
}
