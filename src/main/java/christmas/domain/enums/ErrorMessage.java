package christmas.domain.enums;

public enum ErrorMessage {
    INVALID_ORDER_EXCEPTION("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_DATE_EXCEPTION("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NUMBER_FORMAT_EXCEPTION("");

    private final static String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return ERROR_PREFIX + message;
    }
}
