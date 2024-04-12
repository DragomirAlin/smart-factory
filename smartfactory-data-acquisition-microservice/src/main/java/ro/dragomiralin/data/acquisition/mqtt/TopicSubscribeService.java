package ro.dragomiralin.data.acquisition.mqtt;

public interface TopicSubscribeService {
    void unsubscribe(String topic);
    void subscribe(String userId, String topic);
}
