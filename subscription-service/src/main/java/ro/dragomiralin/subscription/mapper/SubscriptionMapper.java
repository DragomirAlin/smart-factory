package ro.dragomiralin.subscription.mapper;

import org.mapstruct.Mapper;
import ro.dragomiralin.subscription.dto.SubscriptionDTO;
import ro.dragomiralin.subscription.entity.Subscription;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    Subscription toSubscription(SubscriptionDTO subscriptionDTO);

    SubscriptionDTO toSubscriptionDTO(Subscription subscription);
}
