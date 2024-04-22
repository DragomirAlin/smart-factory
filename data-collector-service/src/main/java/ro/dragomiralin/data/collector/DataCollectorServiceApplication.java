package ro.dragomiralin.data.collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DataCollectorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCollectorServiceApplication.class, args);
    }

}
