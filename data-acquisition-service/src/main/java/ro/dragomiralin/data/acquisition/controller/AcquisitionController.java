package ro.dragomiralin.data.acquisition.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import ro.dragomiralin.data.acquisition.mqtt.AcquisitionService;
import ro.dragomiralin.data.acquisition.mqtt.PublishService;
import ro.dragomiralin.data.acquisition.mqtt.TopicSubscribeService;
import ro.dragomiralin.data.acquisition.mqtt.model.Message;
import ro.dragomiralin.data.acquisition.mqtt.model.PaginationResponse;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/mqtt")
@RequiredArgsConstructor
public class AcquisitionController {
    private final PublishService publishService;
    private final TopicSubscribeService topicSubscribeService;
    private final AcquisitionService acquisitionService;

    @GetMapping
    public ResponseEntity<String> test(@AuthenticationPrincipal Jwt principal) {
        return new ResponseEntity<>(String.format("Endpoint Test from mqtt-microservice. User=%s", principal.getClaimAsString("preferred_username")),
                HttpStatus.ACCEPTED);
    }

    @PostMapping("/publish")
    public ResponseEntity<Void> publish(@AuthenticationPrincipal Jwt principal, @RequestBody Message message) {
        publishService.publish(message);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/unsubscribe")
    public ResponseEntity<Void> unsubscribe(@AuthenticationPrincipal Jwt principal, @RequestParam String topic) {
        topicSubscribeService.unsubscribe(topic);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/subscribe")
    public ResponseEntity<Void> subscribe(@AuthenticationPrincipal Jwt principal, @RequestParam String topic) {
        String userId = principal.getClaimAsString("sub");
        topicSubscribeService.subscribe(userId, topic);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/data")
    public ResponseEntity<PaginationResponse> allData(@AuthenticationPrincipal Jwt principal, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "25") int size) {
        return new ResponseEntity<>(acquisitionService.getAllData(PageRequest.of(page, size)), HttpStatus.OK);
    }

    @GetMapping("/data/{topic}")
    public ResponseEntity<PaginationResponse> getDataByTopic(@AuthenticationPrincipal Jwt principal, @PathVariable String topic, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "25") int size) {
        return new ResponseEntity<>(acquisitionService.getDataByTopic(topic,
                PageRequest.of(page, size)), HttpStatus.OK);
    }

    @PostMapping("/data/search")
    public ResponseEntity<PaginationResponse> searchData(@RequestBody Map<String, Object> params, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "25") int size) {
         return new ResponseEntity<>(acquisitionService.searchData(params, PageRequest.of(page, size)), HttpStatus.OK);
    }
}
