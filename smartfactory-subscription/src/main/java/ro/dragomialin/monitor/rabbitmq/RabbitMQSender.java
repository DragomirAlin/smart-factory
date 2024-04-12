package ro.dragomialin.monitor.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Subscription;
import ro.dragomialin.monitor.service.SenderService;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQSender implements SenderService {
    @Value("${smartfactory.rabbitmq.notification.queue}")
    private String queue;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void send(Subscription subscription) {
        rabbitTemplate.convertAndSend(queue, subscription);
    }
}
