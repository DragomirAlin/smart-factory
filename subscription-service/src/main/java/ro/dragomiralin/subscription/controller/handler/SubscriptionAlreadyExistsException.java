package ro.dragomiralin.subscription.controller.handler;

public class SubscriptionAlreadyExistsException extends RuntimeException {
    public SubscriptionAlreadyExistsException(String message) {
        super(message);
    }

    public SubscriptionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public class Messages {
        public static final String SUBSCRIPTION_ALREADY_EXISTS = "Subscription already exists";

        private Messages() {
        }


    }
}
