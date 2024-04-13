package ro.dragomialin.monitor.service;

import ro.dragomialin.monitor.common.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription add(Subscription subscription);
    void delete(String id);
    List<Subscription> getAllMonitors();
    Subscription getMonitorById(String id);

}
