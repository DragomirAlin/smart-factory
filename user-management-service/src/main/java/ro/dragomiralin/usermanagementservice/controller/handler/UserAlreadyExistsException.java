package ro.dragomiralin.usermanagementservice.controller.handler;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public class Messages {
        public static final String USER_ALREADY_EXISTS = "User with email %s already exists";

        private Messages() {
        }

        public static String userAlreadyExistsMessage(String email) {
            return String.format(USER_ALREADY_EXISTS, email);
        }
    }
}
