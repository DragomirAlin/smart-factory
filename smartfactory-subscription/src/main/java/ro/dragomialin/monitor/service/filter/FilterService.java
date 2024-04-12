package ro.dragomialin.monitor.service.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.common.Subscription;

import javax.annotation.PostConstruct;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilterService {
    private Map<String, Filter> filterList;
    private final ApplicationContext applicationContext;

    @PostConstruct
    private void addFilters() {
        this.filterList = applicationContext.getBeansOfType(Filter.class);
    }

    public boolean applyFilters(Data data, Subscription subscription) {
        return filterList.values().stream()
                .allMatch(f -> f.apply(data, subscription));
    }

}
