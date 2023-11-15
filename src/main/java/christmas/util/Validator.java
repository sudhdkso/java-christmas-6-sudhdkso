package christmas.util;

import christmas.domain.enums.ErrorMessage;

public class Validator {
    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new ErrorException(ErrorMessage.INVALID_ORDER_RETRY_EXCEPTION);
        }
    }
}
