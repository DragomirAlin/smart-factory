package ro.dragomialin.monitor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.common.Subscription;
import ro.dragomialin.monitor.service.filter.FilterService;
import ro.dragomialin.monitor.rabbitmq.RabbitMQSender;


@Slf4j
@Service
@RequiredArgsConstructor
public class MessageGateway {
    private final SubscriptionService subscriptionService;
    private final RabbitMQSender rabbitMQSender;
    private final FilterService filterService;

    public void processData(Data data) {
        subscriptionService.getAllMonitors()
                .forEach(monitor -> this.handle(data, monitor));
    }

    private void handle(Data data, Subscription subscription) {
        boolean isAlert = filterService.applyFilters(data, subscription);

        if (isAlert) {
            log.info("Send notification for monitor={}.", subscription.getId());
            rabbitMQSender.send(subscription);
        }
    }
}
