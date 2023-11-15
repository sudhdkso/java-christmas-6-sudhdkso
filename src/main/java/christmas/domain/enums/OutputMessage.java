package christmas.domain.enums;

import static christmas.domain.enums.EventConstatns.EVENT_MONTH;

public class OutputMessage {
    public static String ORDER_MENU_TITLE = "주문 메뉴";
    public static String TOTAL_BENEFIT_TITLE = "혜택 내역";
    public static String TOTAL_AMOUNT_TITLE = "할인 전 총주문 금액";
    public static String GIVE_AWAY_TITLE = "증정 메뉴";
    public static String TOTAL_BENEFIT_AMOUNT_TITLE = "총혜택 금액";
    public static String TOTAL_PAYMENT_AMOUNT_TITLE = "할인 후 예상 결제 금액";
    public static String MONTH_EVENT_BEDAGE_TITLE = String.format("%d월 이벤트 배지", EVENT_MONTH);
}
