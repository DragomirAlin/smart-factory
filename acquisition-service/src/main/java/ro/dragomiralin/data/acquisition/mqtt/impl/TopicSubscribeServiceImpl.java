package ro.dragomiralin.data.acquisition.mqtt.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomiralin.data.acquisition.configuration.MQTTClient;
import ro.dragomiralin.data.acquisition.mqtt.SubscriptionService;
import ro.dragomiralin.data.acquisition.mqtt.TopicSubscribeService;
import ro.dragomiralin.data.acquisition.mqtt.model.TopicSubscription;
import ro.dragomiralin.data.acquisition.mqtt.AcquisitionService;
import ro.dragomiralin.data.acquisition.common.exception.HttpError;

import javax.annotation.PostConstruct;


@Slf4j
@Service
@RequiredArgsConstructor
public class TopicSubscribeServiceImpl implements TopicSubscribeService {
    private final SubscriptionService subscriptionService;
    private final AcquisitionService acquisitionService;
    private static final String NUMBER_SIGN = "#";
    private final MQTTClient mqttClient;

    @PostConstruct
    public void subscribeAll() {
        subscriptionService.list().forEach(topicSubscription -> {
            try {
                this.subscribeWithResponse(topicSubscription);
            } catch (Exception e) {
                log.error("Subscribe failed, topic: {}", topicSubscription.getTopic(), e);
            }
        });
    }

    public void unsubscribe(String topic) {
        subscriptionService.deleteByTopic(topic);
        try {
            mqttClient.getClient().subscribeWithResponse(topic);
            log.info("Unsubscribe to: " + topic);
        } catch (Exception e) {
            log.error("An error occurred while unsubscribing to {}", topic, e);
            throw HttpError.badRequest(String.format("Unsubscribe failed, topic %s.", topic));
        }
    }

    @Override
    public void subscribe(String userId, String topic) {
        if (topic.contains(NUMBER_SIGN)) {
            throw HttpError.badRequest(String.format("It is not possible to subscribe to %s topic.", NUMBER_SIGN));
        }

        var subscription = subscriptionService.create(TopicSubscription.builder()
                .topic(topic)
                .userId(userId)
                .build());

        this.subscribeWithResponse(subscription);
        log.info("Subscribed with success to {} topic.", topic);
    }

    private void subscribeWithResponse(TopicSubscription topicSubscription) {
        try {
            mqttClient.getClient().subscribeWithResponse(topicSubscription.getTopic(), (s, mqttMessage)
                    -> acquisitionService.save(topicSubscription.getTopic(), mqttMessage));
        } catch (Exception e) {
            log.error("An error occurred while subscribing to {}.", topicSubscription.getTopic(), e);
            throw HttpError.badRequest(String.format("Subscribe failed, details=%s", e.getMessage()));
        }
    }

}
