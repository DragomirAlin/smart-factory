package ro.dragomialin.monitor.common.sensors;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class GoogleMini extends Acquisition {
    private String message;
}
