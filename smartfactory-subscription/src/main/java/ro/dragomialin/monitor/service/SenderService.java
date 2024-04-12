package ro.dragomialin.monitor.service;

import ro.dragomialin.monitor.common.Subscription;

public interface SenderService {
    void send(Subscription subscription);
}
