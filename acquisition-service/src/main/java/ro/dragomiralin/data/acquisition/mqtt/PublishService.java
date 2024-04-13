package ro.dragomiralin.data.acquisition.mqtt;

import ro.dragomiralin.data.acquisition.mqtt.model.Message;

public interface PublishService {
    void publish(Message message);
}

