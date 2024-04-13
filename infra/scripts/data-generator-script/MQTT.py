import paho.mqtt.client as mqtt

class MQTT:
    def __init__(self, host, port):
        self.host = host
        self.port = port
        self.client = None

    def connect(self):
        self.client = mqtt.Client()
        self.client.connect(self.host, self.port)
        return self

    def publish(self, topic, payload):
        self.client.publish(topic, payload)
