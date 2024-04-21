package ro.dragomiralin.subscriptionservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomiralin.subscriptionservice.controller.handler.SubscriptionNotFoundException;
import ro.dragomiralin.subscriptionservice.dto.SubscriptionDTO;
import ro.dragomiralin.subscriptionservice.dto.UserDTO;
import ro.dragomiralin.subscriptionservice.entity.Subscription;
import ro.dragomiralin.subscriptionservice.mapper.SubscriptionMapper;
import ro.dragomiralin.subscriptionservice.repository.SubscriptionRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionMapper subscriptionMapper;
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionDTO createSubscription(UserDTO userDTO, SubscriptionDTO subscriptionDTO) {
        Subscription subscription = subscriptionMapper.toSubscription(subscriptionDTO);
        subscription.setUserId(userDTO.getId());

        subscription = subscriptionRepository.save(subscription);
        log.info("Subscription with topic {} for user with id {} has been created.", subscription.getConnection().getTopic(), userDTO.getId());

        return subscriptionMapper.toSubscriptionDTO(subscription);
    }

    public List<SubscriptionDTO> getAllSubscriptions(UserDTO userDTO) {
        return subscriptionRepository.findAllByUserId(userDTO.getId())
                .stream()
                .map(subscriptionMapper::toSubscriptionDTO)
                .toList();
    }

    public SubscriptionDTO getSubscriptionById(UserDTO userDTO, String id) {
        return subscriptionRepository.findByIdAndUserId(id, userDTO.getId())
                .map(subscriptionMapper::toSubscriptionDTO)
                .orElseThrow(() -> new SubscriptionNotFoundException(SubscriptionNotFoundException.Messages.SUBSCRIPTION_NOT_FOUND));
    }

    public void deleteSubscription(UserDTO userDTO, String id) {
        subscriptionRepository.findByIdAndUserId(id, userDTO.getId())
                .ifPresent(subscriptionRepository::delete);
        log.info("Subscription with id {} for user with id {} has been deleted.", id, userDTO.getId());
    }
}
