package ro.dragomialin.monitor.service.filter.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;
import ro.dragomialin.monitor.common.AcqusitionType;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.common.Subscription;
import ro.dragomialin.monitor.common.sensors.Dth22;
import ro.dragomialin.monitor.service.filter.Filter;
import ro.dragomialin.monitor.service.filter.FilterUtils;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class HumidityFilter implements Filter {
    private final ObjectMapper objectMapper;
    private final List<AcqusitionType> allowedAcquisitions = List.of(AcqusitionType.DTH11, AcqusitionType.DTH22);

    @Override
    public boolean apply(Data data, Subscription subscription) {
        if (skipIfNotSupported(subscription)) return true;

        Dth22 dth22 = objectMapper.convertValue(data.getPayload(), Dth22.class);
        Subscription.Dth22 dth22Monitor = objectMapper.convertValue(subscription.getCustomMonitor(), Subscription.Dth22.class);
        return FilterUtils.applyOperator(dth22.getHumidify(), dth22Monitor.getHumidityValue(), dth22Monitor.getHumidityOperator());
    }

    private boolean skipIfNotSupported(Subscription subscription) {
        return BooleanUtils.isFalse(allowedAcquisitions.contains(subscription.getAcquisitionType()));
    }
}
