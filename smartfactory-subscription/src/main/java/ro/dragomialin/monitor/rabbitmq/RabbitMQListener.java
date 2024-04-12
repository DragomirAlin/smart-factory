package ro.dragomialin.monitor.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.service.MessageGateway;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQListener {
    private final MessageGateway messageGateway;

    @RabbitListener(queues = "${smartfactory.rabbitmq.mqtt.acquisition.queue}")
    public void messageFromMQTT(final Data data) {
        log.info("Message from MQTT: {}.", data.getId());
        messageGateway.processData(data);
    }




}
