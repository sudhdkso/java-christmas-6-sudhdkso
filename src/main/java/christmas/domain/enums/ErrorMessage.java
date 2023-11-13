package christmas.domain.enums;

public enum ErrorMessage {
    ERROR_PRIFIX("[ERROR]"),
    MIN_ORDER_COUNT_EXCEPTION("최소 주문 갯수를 만족하지 못했습니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return ERROR_PRIFIX.message + message;
    }
}
