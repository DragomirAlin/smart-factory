package ro.dragomiralin.data.acquisition.mqtt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.dragomiralin.data.acquisition.mqtt.model.TopicSubscription;

import java.util.Optional;


@Repository
public interface SubscriptionRepository extends MongoRepository<TopicSubscription, String> {
    Optional<TopicSubscription> findByTopic(String topic);
}
