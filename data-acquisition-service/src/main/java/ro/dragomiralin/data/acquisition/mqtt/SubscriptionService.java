package ro.dragomiralin.data.acquisition.mqtt;

import ro.dragomiralin.data.acquisition.mqtt.model.TopicSubscription;

import java.util.List;

public interface SubscriptionService {
    TopicSubscription create(TopicSubscription topicSubscription);

    void delete(String id);

    List<TopicSubscription> list();

    TopicSubscription getById(String id);

    void deleteByTopic(String topic);
}
