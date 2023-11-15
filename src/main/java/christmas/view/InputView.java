package christmas.view;

import static christmas.domain.enums.EventConstatns.EVENT_MONTH;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.Util;
import christmas.util.Validator;

public class InputView {
    private static final String ASK_VISIT_DATE = String.format("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.\n", EVENT_MONTH)
            + String.format("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)", EVENT_MONTH);

    private static final String ASK_ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public String readVisitDate() {
        return readInputData(ASK_VISIT_DATE);
    }

    public String readOrderMenu() {
        return readInputData(ASK_ORDER_MENU);
    }

    private String readInputData(String message) {
        System.out.println(message);
        String input = Util.removeSpace(Console.readLine());
        Validator.validateBlank(input);
        System.out.println(input);
        return input;
    }

}
