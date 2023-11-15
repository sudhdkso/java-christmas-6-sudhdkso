package christmas.util;

import christmas.domain.enums.ErrorMessage;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[1-9]*$");

    private Validator() {

    }

    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new ErrorException(ErrorMessage.INVALID_INPUT_EXCEPTION);
        }
    }

    public static void validateVisitDateNumber(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new ErrorException(ErrorMessage.INVALID_DATE_RETRY_EXCEPTION);
        }
    }
}
