package ro.dragomiralin.data.acquisition.configuration;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class MQTTClient {
    @Value("${mqtt.publisher-id}")
    private String mqttPublisherId;
    @Value("${mqtt.server}")
    private String mqttServerAddress;
    private IMqttClient instance;

    public IMqttClient getClient() {
        try {
            if (Objects.isNull(instance)) {
                instance = new MqttClient(mqttServerAddress, mqttPublisherId);
            }

            if (BooleanUtils.isFalse(instance.isConnected())) {
                instance.connect(getOption());
            }
        } catch (MqttException e) {
            log.error("An error occurred while return MQTT client.", e);
        }

        log.info("Issued MQTT client.");
        return instance;
    }

    private MqttConnectOptions getOption() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1);
        return options;
    }
}
