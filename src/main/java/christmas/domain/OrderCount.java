package christmas.domain;

import static christmas.domain.enums.EventConstatns.MIN_ORDER_COUNT;

import christmas.domain.enums.ErrorMessage;
import christmas.util.ErrorException;

public record OrderCount(int count) {
    public OrderCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        validateMinOrderCount(count);
    }

    private void validateMinOrderCount(int count) {
        if (count < MIN_ORDER_COUNT) {
            throw new ErrorException(ErrorMessage.INVALID_ORDER_EXCEPTION);
        }
    }

    @Override
    public int count() {
        return count;
    }
}
