package christmas.util;

import christmas.domain.enums.ErrorMessage;

public class BudgetValidator {
    private BudgetValidator() {

    }

    public static void validate(String input) {
        try {
            long value = Long.parseLong(input);
            validateIntValue(value);
        } catch (NumberFormatException e) {
            throw new ErrorException(ErrorMessage.NUMBER_FORMAT_EXCEPTION);
        }
    }

    private static void validateIntValue(long value) {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            throw new ErrorException(ErrorMessage.OVERFLOW_INT_RANGE_EXCEPTION);
        }
    }
}
