package ro.dragomiralin.subscriptionservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.dragomiralin.subscriptionservice.controller.api.SubscriptionApi;
import ro.dragomiralin.subscriptionservice.dto.SubscriptionDTO;
import ro.dragomiralin.subscriptionservice.dto.UserDTO;
import ro.dragomiralin.subscriptionservice.service.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController implements SubscriptionApi {
    private final SubscriptionService subscriptionService;

    @Override
    public ResponseEntity<SubscriptionDTO> createSubscription(UserDTO userDTO, @RequestBody SubscriptionDTO subscriptionDTO) {
        SubscriptionDTO subscription = subscriptionService.createSubscription(userDTO, subscriptionDTO);
        return ResponseEntity.ok(subscription);
    }

    @Override
    public ResponseEntity<SubscriptionDTO> getSubscriptionById(UserDTO userDTO, @PathVariable String id) {
        SubscriptionDTO subscription = subscriptionService.getSubscriptionById(userDTO, id);
        return ResponseEntity.ok(subscription);
    }

    @Override
    public ResponseEntity<List<SubscriptionDTO>> getAllSubscriptions(UserDTO userDTO) {
        List<SubscriptionDTO> subscriptions = subscriptionService.getAllSubscriptions(userDTO);
        return ResponseEntity.ok(subscriptions);
    }

    @Override
    public ResponseEntity<Void> deleteSubscription(UserDTO userDTO, @PathVariable String id) {
        subscriptionService.deleteSubscription(userDTO, id);
        return ResponseEntity.noContent().build();
    }

}
