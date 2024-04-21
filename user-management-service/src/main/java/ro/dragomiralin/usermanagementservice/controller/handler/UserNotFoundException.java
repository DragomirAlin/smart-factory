package ro.dragomiralin.usermanagementservice.controller.handler;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public class Messages{
        public static final String USER_NOT_FOUND_WITH_EMAIL = "User with email %s not found";
        public static final String USER_NOT_FOUND = "User not found";


        private Messages() {
        }

        public static String userNotFoundMessage(String email) {
            return String.format(USER_NOT_FOUND, email);
        }
    }
}
