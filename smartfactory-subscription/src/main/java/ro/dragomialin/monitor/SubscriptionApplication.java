package ro.dragomialin.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SubscriptionApplication {
	public static void main(String[] args) {
		SpringApplication.run(SubscriptionApplication.class, args);
	}

}
