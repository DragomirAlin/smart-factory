package ro.dragomiralin.data.acquisition.common.sensors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Dth22 {
    private double temperature;
    private double humidify;
}
