package christmas.view;

import static christmas.domain.enums.EventConstatns.EVENT_MONTH;

public class OutputView {
    private static String ORDER_MENU_TITLE = "주문 메뉴";
    private static String TOTAL_BENEFIT_TITLE = "혜택 내역";
    private static String TOTAL_AMOUNT_TITLE = "할인 전 총주문 금액";
    private static String GIVE_AWAY_TITLE = "증정 메뉴";
    private static String TOTAL_BENEFIT_AMOUNT_TITLE = "총혜택 금액";
    private static String TOTAL_PAYMENT_AMOUNT_TITLE = "할인 후 예상 결제 금액";
    private static String MONTH_EVENT_BEDAGE_TITLE = String.format("%d월 이벤트 배지", EVENT_MONTH);

    public void printOrderMenu(String orderMenus) {
        printTitle(ORDER_MENU_TITLE);
        System.out.println(orderMenus);

    }

    public void printTotalAmount(int totalAmount) {
        printTitle(TOTAL_AMOUNT_TITLE);
        System.out.println(String.format("%,d원\n", totalAmount));
    }

    public void printGiveAwayMenu(String giveWay) {
        printTitle(GIVE_AWAY_TITLE);
        System.out.println(giveWay);
    }

    public void printTotalBenefit(String totalBenefit) {
        printTitle(TOTAL_BENEFIT_TITLE);
        System.out.println(totalBenefit);
    }

    public void printTotalBenefitAmount(int benefitAmount) {
        printTitle(TOTAL_BENEFIT_AMOUNT_TITLE);
        System.out.println(String.format("%,d원\n", benefitAmount));
    }

    public void printTotalPaymentAmount(int paymentAmount) {
        printTitle(TOTAL_PAYMENT_AMOUNT_TITLE);
        System.out.println(String.format("%,d원\n", paymentAmount));
    }

    public void printEventBedge(String eventBedge) {
        printTitle(MONTH_EVENT_BEDAGE_TITLE);
        System.out.println(eventBedge);
    }

    private void printTitle(String message) {
        System.out.println(String.format("<%s>", message));
    }

}
