package christmas;

import christmas.controller.EventController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new EventController(new InputView(), new OutputView()).run();
    }
}
