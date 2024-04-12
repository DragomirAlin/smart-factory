package ro.dragomialin.monitor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.dragomialin.monitor.common.Subscription;
import ro.dragomialin.monitor.service.SubscriptionService;

import java.util.List;

@RequestMapping("/subscription")
@RestController
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @GetMapping
    private String testSubscription() {
        return "Subscription service works";
    }

    @PostMapping()
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.add(subscription);
    }

    @GetMapping("/all")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllMonitors();
    }

    @GetMapping("/{id}")
    public Subscription getSubscription(@PathVariable String id) {
        return subscriptionService.getMonitorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable String id) {
        subscriptionService.delete(id);
    }

}
