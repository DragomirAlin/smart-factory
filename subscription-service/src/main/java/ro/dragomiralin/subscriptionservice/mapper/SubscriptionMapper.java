package ro.dragomiralin.subscriptionservice.mapper;

import org.mapstruct.Mapper;
import ro.dragomiralin.subscriptionservice.dto.SubscriptionDTO;
import ro.dragomiralin.subscriptionservice.entity.Subscription;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    Subscription toSubscription(SubscriptionDTO subscriptionDTO);

    SubscriptionDTO toSubscriptionDTO(Subscription subscription);
}
