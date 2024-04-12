package ro.dragomiralin.data.acquisition.rabbitmq;

public interface RabbitMQSenderService {
    void send(Object subscription);
}
