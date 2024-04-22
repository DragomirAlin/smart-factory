package ro.dragomiralin.subscription.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.dragomiralin.subscription.entity.Subscription;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {

    List<Subscription> findAllByUserId(String userId);

    Optional<Subscription> findByIdAndUserId(String id, String userId);

}
