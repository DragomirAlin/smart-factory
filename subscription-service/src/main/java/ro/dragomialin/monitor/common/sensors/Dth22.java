package ro.dragomialin.monitor.common.sensors;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Dth22 extends Acquisition {
    private double temperature;
    private double humidify;
}
