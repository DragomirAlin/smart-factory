package ro.dragomiralin.subscription.util;


import ro.dragomiralin.subscription.dto.SubscriptionDTO;
import ro.dragomiralin.subscription.dto.UserDTO;

public class TestDataUtil {

    private TestDataUtil() {

    }

    public static UserDTO givenUserDTO() {
        return UserDTO.builder()
                .sub("test")
                .firstName("test")
                .lastName("test")
                .email("test@cc")
                .build();
    }

    public static SubscriptionDTO givenSubscriptionDTO() {
        return SubscriptionDTO.builder()
                .name("Lights")
                .description("test")
                .connection(SubscriptionDTO.Connection.builder()
                        .topic("zz01.topic")
                        .url("http://localhost:8080/api/v1/subscription")
                        .build())
                .build();
    }
}
