package ro.dragomiralin.data.acquisition.mqtt.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.dragomiralin.data.acquisition.common.Data;
import ro.dragomiralin.data.acquisition.common.Metadata;
import ro.dragomiralin.data.acquisition.common.Payload;
import ro.dragomiralin.data.acquisition.mqtt.model.PaginationResponse;
import ro.dragomiralin.data.acquisition.mqtt.repository.DataRepository;
import ro.dragomiralin.data.acquisition.mqtt.AcquisitionService;
import ro.dragomiralin.data.acquisition.rabbitmq.RabbitMQSenderService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcquisitionServiceImpl implements AcquisitionService {
    private final DataRepository dataRepository;
    private final ObjectMapper objectMapper;
    private final RabbitMQSenderService senderService;
    private final MongoTemplate mongoTemplate;

//    @PostConstruct
//    public void checkIndexes() {
//        try {
//            TextIndexDefinition textIndex = new TextIndexDefinition.TextIndexDefinitionBuilder()
//                    .onField("payload")
//                    .build();
//
//            mongoTemplate.indexOps(Data.class).ensureIndex(textIndex);
//            log.info("The Data fields was indexed.");
//        } catch (Exception e) {
//            log.error("Could not set Data indexes.", e);
//        }
//    }

    @Override
    public void save(String topic, MqttMessage message) {
        try {
            var payload = objectMapper.readValue(message.getPayload(), Payload.class);
            var data = dataRepository.save(Data.builder()
                    .topic(topic)
                    .payload(payload.getPayload())
                    .metadata(payload.getMetadata())
                    .build());
            senderService.send(data);
        } catch (Exception e) {
            log.error("An error occurred while inserting data from broker.", e);
        }
    }

//    @Scheduled(fixedDelay = 3000)
//    public void test() {
//        log.info("test");
//        senderService.send(Data.builder()
//                .topic("test")
//                .metadata(Metadata.builder()
//                        .build())
//                .id("test-id")
//                .arriveAt(new Date())
//                .build());
//    }

    @Override
    public PaginationResponse getDataByTopic(String topic, PageRequest pageRequest) {
        log.info("Get all data by topic={}.", topic);
        Page<Data> dataPage = dataRepository.findAllByTopic(topic, pageRequest);
        return PaginationResponse.builder()
                .data(dataPage.getContent())
                .currentPage(dataPage.getNumber())
                .totalItems(dataPage.getTotalElements())
                .totalPages(dataPage.getTotalPages())
                .pageSize(dataPage.getSize())
                .build();
    }

    @Override
    public PaginationResponse getAllData(PageRequest pageRequest) {
        log.info("Get all data from database.");
        Page<Data> dataPage = dataRepository.findAll(pageRequest);
        return PaginationResponse.builder()
                .data(dataPage.getContent())
                .currentPage(dataPage.getNumber())
                .totalItems(dataPage.getTotalElements())
                .totalPages(dataPage.getTotalPages())
                .pageSize(dataPage.getSize())
                .build();
    }

    @Override
    public PaginationResponse searchData(Map<String, Object> attributes, PageRequest pageRequest) {
        Criteria andCriteria = new Criteria();
        List<Criteria> criteria = new ArrayList<>();

        attributes.forEach((key, value) -> {
            Criteria expression = new Criteria();
            expression.and(String.format("payload.%s", key)).is(value);
            criteria.add(expression);
        });

        Query query = new Query().addCriteria(andCriteria.andOperator(criteria.toArray(new Criteria[criteria.size()]))).with(pageRequest);
        List<Data> data = mongoTemplate.find(query, Data.class);
        Page<Data> dataPage = PageableExecutionUtils.getPage(
                data,
                pageRequest,
                () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), Data.class));

        return PaginationResponse.builder()
                .data(dataPage.getContent())
                .currentPage(dataPage.getNumber())
                .totalItems(dataPage.getTotalElements())
                .totalPages(dataPage.getTotalPages())
                .pageSize(dataPage.getSize())
                .build();
    }
}
