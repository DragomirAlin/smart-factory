package ro.dragomialin.monitor.common.sensors;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Mq135 extends Acquisition {
    private double gasValue;
}
