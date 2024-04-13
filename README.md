# Smart Factory Platform
![java](https://img.shields.io/badge/Java-17-green)
![spring](https://img.shields.io/badge/Spring-3.0.0-green)
![last commit](https://img.shields.io/github/last-commit/dragomiralin/smartfactory)
![contributors](https://img.shields.io/github/contributors/dragomiralin/smartfactory)
![rest-api](https://img.shields.io/badge/REST-API-violet)
![microservices](https://img.shields.io/badge/Microservices-Architecture-blue)

## Overview
Smart Factory is an IoT opensource project whose main purpose is to monitor, verify, manage and control sensors, modules and smart devices in Smart City, Smart Environments and many others. This project was born from my passion for technology, microservices, cloud and internet of things.

In developing of this project, I'm going to use a lot of tools to understand and learn how to use them. I want to find the best solutions for the project.

The documentation is constantly improving.

I chose the microservice architecture for this project because IoT means Big Data and the system needs to be scalable, available and flexible.

If you want to contribute or/and learn, come on. The main purpose of this project is educational.
> Everything we do is practice for something greater than where we currently are.  Practice only makes for improvement.  – Les Brown

If you have any tips, suggestions or ideas for this project, let me know.

## Software Stack and Tools:
Languages:
<ul>
<li>Java 17 LTS</li>
<li>Typescript 4.1</li>
</ul>

### Frameworks & Tools
| Technology type  | Name  |
|:--------------------- |:----------------- |
| Frontend Framework | Angular 12 |
| Backend Framework | Spring Framework |
| | Spring Boot |
| CSS framework | Bootstrap 5 |
| Build tool | Maven |

### Cloud Tools: Spring Cloud
| Technology type  | Name  |
|:--------------------- |:----------------- |
| API gateway |  Spring Cloud Gateway
| Centralized configuration | Spring Cloud Config
| Declarative HTTP client | Spring Cloud OpenFeign
| Service discovery | 	Spring Cloud Netflix Eureka(tried) / Spring Consul(current)
| Circuit breaker | Spring Cloud Netflix Hystrix
| Client-side load balancing  | Spring Cloud Netflix Ribbon
| Discovery Client | Spring Cloud Kubernetes

### Logging, Monitoring & Notification
| Technology type  | Name  |
|:--------------------- |:----------------- |
| Distributed tracing | Spring Cloud Sleuth
| Distributed tracing  | Zipkin
| Search and Analytics engine | Elasticsearch
| Process logs | Logstash
| Analytics and Visualization | Kibana
| Monitor and Manage | Spring Boot Actuator
| Microservices state | Spring Boot Admin

### Messaging:
| Technology | Descripion |
|:---------------------|:---------------------  
| RabbitMQ | internal messaging |
| MQTT | IoT communication|

### Databases:
| Technology | Descripion  |
|:---------------------|:---------------------  
| NoSQL | MongoDB
| SQL | Postgres

### Security: 
| Technology  | Descripion  |
|:--------------------- |:----------------- |
| OAuth 2.0 |  Protocol
| Keycloak |  Identity and Access Management

### Testing:
| Technology | Descripion  |
|:--------------------- |:----------------- |
| JUnit & Mockito |  Spring
| Karma  |  Angular testing
| Sonar Cloud | Code Quality & Security
| Testcontainers | Spring

### CI/CD:
| Technology  | Description  |
|:--------------------- |:----------------- |
| Github Actions |  Cloud CI
| Jenkins |  Local CI
| Docker | Containerization
| Docker Registry | Docker Hub
| Argo CD | Continuous deployment
| Tekton | Kubernetes
| Helm | Package apps

### Deployment:
Kubernetes - Automating deployment, scaling, and management.
| Technology  | Type  |
|:--------------------- |:----------------- |
| minikube | Local development
| k3s      | Staging - [Raspberry Pi 4 Cluster](https://github.com/DragomirAlin/raspberry-k8s-cluster)
| kubespray | Production

### Automation
| Technology  | Description  |
|:--------------------- |:--------------------- |
| Terraform |  Infrastructure provisioning - nodes, networks, security groups, gateways, loadbalancers |
| Ansible | Deploy and manage Kubespray |

### API documentation
| Technology |
|:--------------------- |
| Swagger OpenAPI 3 |

## Internet of Things
A list of devices compatible with this system. The list is constantly growing with the development of new adapters and source codes for devices.

| Type  | Description  | Communication | Implementation
|:--------------------- |:----------------- |:-----------------| :----------------- |
| Module |  ESP8266 | MQTT | In progress
| Module |  ESP32 | MQTT | In progress
| SBC | Raspberry PI | HTTP/MQTT | In progress
| Device | Google Home | HTTP | In progress

### Embedded
Languages:
<ul>
    <li>C++</li>
    <li>Python</li>
</ul>

## Organization
I use Meistertask for organization and planning
![Tasks](documentation/images/organization.png)

## Development Tools
| Name | Description  | 
|:--------------------- |:----------------- |
| Github |  Git repository hosting service 
| Git |  Version control 
| IntelliJ IDEA | Java development
| WebStorm | Frontend development
| PyCharm | Scripting development
| VS Code | YAML Editor
| Slack | Webhooks notification
| Meistertask | Planning/Organization
| Lens K8s |The Kubernetes IDE
| Postman | Test API
| Swagger UI | Create API
| MongoDB Compass| GUI for MongoDB
| MQTTfx | MQTT client
| DBeaver | GUI for SQL
| Arduino | Embedded dev

## Desktop Dev
| Name | Version | 
|:--------------------- |:----------------- |
| Ubuntu | 20.04

## Features and Requirements
#### Functional requirements 
* Data ingestion and stream processing
* Device management
* Edge computing
* Advanced analytics
* Notification/Alerting
* Enterprise integration with business
systems.
#### Non-functional requirements 
* Security
* Stability
* Scalability
* Reliability
* Resistance
* Interoperability
* Maintainability
* Accessibility
## Arhitecture
#### Draw
#### UML

## Repositories
| Name  | URL
|:--------------------- |:----------------- 
| Data Acqusition | [DragomirAlin/smartfactory-data-acquisition-microservice](https://github.com/DragomirAlin/smartfactory-data-acquisition-microservice)
| Deployment | [DragomirAlin/smartfactory-deployment](https://github.com/DragomirAlin/smartfactory-deployment)
| Frontend | [DragomirAlin/smartfactory-ui-angular](https://github.com/DragomirAlin/smartfactory-angular-ui)
| Subscription Service | [DragomirAlin/smartfactory-subscription](https://github.com/DragomirAlin/smartfactory-subscription)
| API Gateway | [DragomirAlin/smartfactory-api-gateway](https://github.com/DragomirAlin/smartfactory-api-gateway)
| Dashboard Admin | [DragomirAlin/smartfactory-admin](https://github.com/DragomirAlin/smartfactory-admin)
| Discovery Service | [DragomirAlin/smartfactory-discovery-service](https://github.com/DragomirAlin/smartfactory-discovery-service)
| Config Service | [DragomirAlin/smartfactory-config-microservice](https://github.com/DragomirAlin/smartfactory-config-microservice)
| Notification Service | currently: private
| Swagger API | [DragomirAlin/smartfactory-swagger-api](https://github.com/DragomirAlin/smartfactory-swagger-api)


# pictures from the project


### Eureka Discovery Service
![Eureka Discovery Service](documentation/images/discovery.png)


### CI Jenkins for local dev
![CI Jenkins for local dev](documentation/images/jenkins.png)

### Kubernetes Deployment
![Kubernetes Deployment](documentation/images/deployment.png)

### Admin Dashboard
![Admin Dashboard](documentation/images/admin.png)

### Admin Dashboard - Services Overview
![Admin Dashboard Services Overview](documentation/images/admin-2.png)

### Arhitecture V1
![Initial Arhitecture](documentation/images/SmartFactory-Arhitecture-v1.0.0.png)

### Arhitecture V2
![Arhitecture V2](documentation/images/smartfactory-v2.png)

### Arhitecture V3 - soon

### CI Pipline
![CI Pipline](documentation/images/dev-pipline.png)


### Argo CD
![Argo CD](documentation/images/argocd.png)


### Docker Hub
![Docker Registry](documentation/images/dockerhub.png)

### ELK - Logging
![Logs](documentation/images/elastic.png)

### Slack Notifications
![Slack](documentation/images/slack.png)
