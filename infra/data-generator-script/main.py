import time
import MQTT
import random
import json
import datetime

host = "localhost"
port = 1883


def data_dth22(mqtt, topic, frequency):
    while True:
        print("MQTT: publish on topic " + topic)
        data = {
            "payload": {
                "temperature": random.randint(0, 35),
                "humidity": random.randint(0, 100)
            },
            "metadata": {
                "macAddress": "02:00:00:%02x:%02x:%02x" % (random.randint(0, 255),
                                                           random.randint(0, 255),
                                                           random.randint(0, 255)),
                "device": "ESP8266",
                "location": "City, Street, nr / coordinates",
                "maintainer": "Mr. X",
            }

        }

        mqtt.publish(topic, json.dumps(data, indent=4, sort_keys=True, default=str))
        time.sleep(frequency)


def google_mini(mqtt, topic, frequency):
    while True:
        print("MQTT: publish on topic " + topic)
        data = {
            "payload": {
                "message": "Turn OFF: lights"
            },
            "metadata": {
                "macAddress": "02:00:00:%02x:%02x:%02x" % (random.randint(0, 255),
                                                           random.randint(0, 255),
                                                           random.randint(0, 255)),
                "device": "Google Mini",
                "location": "City, Street, nr / coordinates",
                "maintainer": "Mr. X",
            }

        }

        mqtt.publish(topic, json.dumps(data, indent=4, sort_keys=True, default=str))
        time.sleep(frequency)


def main():
    client = MQTT.MQTT(host, port).connect()
    data_dth22(client, "city/street", 1)
    google_mini(client, "city/street", 1)


if __name__ == "__main__":
    main()
