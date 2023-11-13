package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_VISIT_DATE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"
            + "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private static final String ASK_ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    public InputView(){

    }

    public String readValidatetDate() {
        return readInputData(ASK_VISIT_DATE);
    }

    public String readOrderMenu(){
        return readInputData(ASK_ORDER_MENU);
    }

    private String readInputData(String message){
        System.out.println(message);
        String input = Console.readLine();
        System.out.println(input);
        return input;
    }

}
