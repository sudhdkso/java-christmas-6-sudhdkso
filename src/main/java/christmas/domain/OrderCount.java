package christmas.domain;

import christmas.domain.enums.ErrorMessage;
import christmas.util.ErrorException;

public record OrderCount(int count) {
    public OrderCount(int count){
        validate(count);
        this.count = count;
    }

    private void validate(int count){
        validateMinMenuCount(count);
    }

    private void validateMinMenuCount(int count){
        if(count < 1){
            throw new ErrorException(ErrorMessage.MIN_ORDER_COUNT_EXCEPTION);
        }
    }

    @Override
    public int count() {
        return count;
    }
}
