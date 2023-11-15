package christmas.domain.enums;

public enum ErrorMessage {
    INVALID_ORDER_RETRY_EXCEPTION("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_DATE_RETRY_EXCEPTION("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_DATE_EXCEPTION("유효하지 않은 날짜입니다."),
    INVALID_MENU_EXCEPTION("유효하지 않은 메뉴입니다."),
    NUMBER_FORMAT_EXCEPTION("올바른 숫자가 아닙니다."),
    OVERFLOW_INT_RANGE_EXCEPTION("정수범위를 넘어간 입력입니다. 다시 입력해 주세요."),
    INVALID_INPUT_EXCEPTION("잘못된 입력입니다. 다시 입력해 주세요.");

    private final static String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
