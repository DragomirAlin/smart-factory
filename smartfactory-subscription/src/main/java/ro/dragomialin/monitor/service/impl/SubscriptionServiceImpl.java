package ro.dragomialin.monitor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Subscription;
import ro.dragomialin.monitor.common.exception.HttpError;
import ro.dragomialin.monitor.repository.SubscriptionRepository;
import ro.dragomialin.monitor.service.SubscriptionService;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository repository;

    @Override
    public Subscription add(Subscription subscription) {
        log.info("Add new subscription to system. Subscription type={}.", subscription.getAcquisitionType());
        return repository.save(subscription);
    }

    @Override
    public void delete(String id) {
        Subscription subscription = getMonitorById(id);
        log.info("Delete subscription with id={}.", subscription.getId());
        repository.delete(subscription);
    }

    @Override
    public List<Subscription> getAllMonitors() {
        log.info("Get all subscriptions.");
        return repository.findAll();
    }

    @Override
    public Subscription getMonitorById(String id) {
        log.info("Get subscription by id={}.", id);
        return repository.findById(id)
                .orElseThrow(() -> HttpError.notFound(String.format("Monitor with id %s was not found.", id)));
    }
}
