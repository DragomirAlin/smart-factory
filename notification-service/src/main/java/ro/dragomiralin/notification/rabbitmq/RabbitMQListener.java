package ro.dragomiralin.notification.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ro.dragomiralin.notification.common.Subscription;
import ro.dragomiralin.notification.service.MessageGateway;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQListener {
    private final MessageGateway messageGateway;

    @RabbitListener(queues = "${smartfactory.rabbitmq.notification.queue}")
    public void messageFromMonitoring(final Subscription monitor) {
        messageGateway.handle(monitor);
    }


}
