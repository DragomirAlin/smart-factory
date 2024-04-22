package ro.dragomiralin.subscription.controller.handler;

public class SubscriptionNotFoundException extends RuntimeException {
    public SubscriptionNotFoundException(String message) {
        super(message);
    }

    public SubscriptionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public class Messages {
        public static final String SUBSCRIPTION_NOT_FOUND = "Subscription not found";


        private Messages() {
        }
    }
}
