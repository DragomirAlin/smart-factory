package ro.dragomialin.monitor.service.filter.filters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.common.Subscription;
import ro.dragomialin.monitor.service.filter.Filter;

@Slf4j
@Service
@RequiredArgsConstructor
public class MacAddressFilter implements Filter {

    @Override
    public boolean apply(Data data, Subscription subscription) {
        return StringUtils.isBlank(subscription.getMacAddress()) || StringUtils.equals(data.getMetadata().getMacAddress(), subscription.getMacAddress());
    }
}
