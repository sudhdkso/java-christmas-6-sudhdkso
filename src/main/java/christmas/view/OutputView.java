package christmas.view;

import static christmas.domain.enums.EventConstatns.EVENT_MONTH;

import christmas.domain.enums.OutputMessage;

public class OutputView {
    public void printEventPreviewTitle(int visitDate) {
        System.out.println(String.format("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", EVENT_MONTH, visitDate));
        printNewLine();
    }

    public void printOrderMenu(String orderMenus) {
        printTitle(OutputMessage.ORDER_MENU_TITLE);
        System.out.println(orderMenus);

    }

    public void printTotalAmount(int totalAmount) {
        printTitle(OutputMessage.TOTAL_AMOUNT_TITLE);
        System.out.println(String.format("%,d원", totalAmount));
        printNewLine();
    }

    public void printGiveAwayMenu(String giveWay) {
        printTitle(OutputMessage.GIVE_AWAY_TITLE);
        System.out.println(giveWay);
    }

    public void printTotalBenefit(String totalBenefit) {
        printTitle(OutputMessage.TOTAL_BENEFIT_TITLE);
        System.out.println(totalBenefit);
    }

    public void printTotalBenefitAmount(int benefitAmount) {
        printTitle(OutputMessage.TOTAL_BENEFIT_AMOUNT_TITLE);
        System.out.println(String.format("%,d원", benefitAmount));
        printNewLine();
    }

    public void printTotalPaymentAmount(int paymentAmount) {
        printTitle(OutputMessage.TOTAL_PAYMENT_AMOUNT_TITLE);
        System.out.println(String.format("%,d원", paymentAmount));
        printNewLine();
    }

    public void printEventBedge(String eventBedge) {
        printTitle(OutputMessage.MONTH_EVENT_BEDAGE_TITLE);
        System.out.println(eventBedge);
        printNewLine();
    }

    private void printTitle(String message) {
        System.out.println(String.format("<%s>", message));
    }

    private void printNewLine() {
        System.out.println();
    }
}
