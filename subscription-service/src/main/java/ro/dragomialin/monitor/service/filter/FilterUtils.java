package ro.dragomialin.monitor.service.filter;

import ro.dragomialin.monitor.common.Subscription;

public class FilterUtils {

    private FilterUtils(){

    }

    public static boolean applyOperator(double firstValue, double secondValue, Subscription.Operator operator){
        return switch (operator){
            case LESS -> firstValue < secondValue;
            case EQUALTO -> firstValue == secondValue;
            case GREATHER -> firstValue > secondValue;
            case None -> true;
        };
    }
}
