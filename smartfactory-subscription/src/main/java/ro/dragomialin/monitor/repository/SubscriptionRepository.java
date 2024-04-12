package ro.dragomialin.monitor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.dragomialin.monitor.common.Subscription;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
}
