package ro.dragomiralin.data.acquisition.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Service
@Configuration
public class RabbitMQConfiguration {
    @Value("${smartfactory.rabbitmq.mqtt.exchange}")
    private String mqttExchange;
    @Value("${smartfactory.rabbitmq.mqtt.subscription.queue}")
    private String subscriptionQueue;
    @Value("${smartfactory.rabbitmq.mqtt.gateway.queue}")
    private String gatewayQueue;

    @Bean
    Queue subscriptionQueue() {
        return new Queue(subscriptionQueue, false);
    }

    @Bean
    Queue gatewayQueue() {
        return new Queue(gatewayQueue, false);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(mqttExchange);
    }

    @Bean
    Binding bindingSubscription(Queue subscriptionQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(subscriptionQueue).to(fanoutExchange);
    }

    @Bean
    Binding bindingGateway(Queue gatewayQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(gatewayQueue).to(fanoutExchange);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}