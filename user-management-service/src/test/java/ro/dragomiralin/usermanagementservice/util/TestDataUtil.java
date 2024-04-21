package ro.dragomiralin.usermanagementservice.util;

import ro.dragomiralin.usermanagementservice.dto.UserContext;
import ro.dragomiralin.usermanagementservice.dto.UserDTO;
import ro.dragomiralin.usermanagementservice.entity.User;

public class TestDataUtil {

    private TestDataUtil() {

    }

    public static UserContext givenUserContext() {
        return UserContext.builder()
                .sub("test")
                .firstName("test")
                .lastName("test")
                .email("test@cc")
                .build();
    }

    public static User givenUser() {
        return User.builder()
                .sub("test")
                .firstName("test")
                .lastName("test")
                .email("test@cc")
                .build();
    }

    public static UserDTO givenUserDTO() {
        return UserDTO.builder()
                .sub("test")
                .firstName("test")
                .lastName("test")
                .email("test@cc")
                .build();
    }
}
