package ro.dragomiralin.gateway.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ro.dragomiralin.gateway.common.Data;
import ro.dragomiralin.gateway.websocket.WebSocketService;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQListener {
    private final WebSocketService webSocketService;

    @RabbitListener(queues = "${smartfactory.rabbitmq.mqtt.acquisition.queue}")
    public void messageFromMonitoring(final Data data) {
        log.info("Received: {}", data);
        webSocketService.emit(data);
    }
}
