package ro.dragomiralin.data.acquisition.mqtt.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomiralin.data.acquisition.mqtt.SubscriptionService;
import ro.dragomiralin.data.acquisition.mqtt.model.TopicSubscription;
import ro.dragomiralin.data.acquisition.mqtt.repository.SubscriptionRepository;
import ro.dragomiralin.data.acquisition.common.exception.HttpError;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public TopicSubscription create(TopicSubscription topicSubscription) {
        Optional<TopicSubscription> optionalSubscription = subscriptionRepository.findByTopic(topicSubscription.getTopic());

        if (optionalSubscription.isPresent()) {
            throw HttpError.badRequest(String.format("Topic = %s already register in broker.", topicSubscription.getTopic()));
        }
        return subscriptionRepository.save(topicSubscription);
    }

    @Override
    public void delete(String id) {
        var subscription = this.getById(id);
        subscriptionRepository.delete(subscription);
    }

    @Override
    public List<TopicSubscription> list() {
        return subscriptionRepository.findAll();
    }

    @Override
    public TopicSubscription getById(String id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> HttpError.notFound(String.format("Subscription with id = %s was not found.", id)));
    }

    @Override
    public void deleteByTopic(String topic) {
        subscriptionRepository.findByTopic(topic)
                .ifPresent(subscriptionRepository::delete);
    }
}
