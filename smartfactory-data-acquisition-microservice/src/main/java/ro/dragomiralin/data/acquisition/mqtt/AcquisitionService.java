package ro.dragomiralin.data.acquisition.mqtt;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.data.domain.PageRequest;
import ro.dragomiralin.data.acquisition.mqtt.model.PaginationResponse;

import java.util.Map;

public interface AcquisitionService {
    void save(String topic, MqttMessage message);
    PaginationResponse getDataByTopic(String topic, PageRequest pageReques);
    PaginationResponse getAllData(PageRequest pageReques);
    PaginationResponse searchData(Map<String, Object> params, PageRequest pageReques);
}
