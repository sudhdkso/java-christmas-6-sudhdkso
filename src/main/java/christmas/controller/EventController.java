package christmas.controller;

import christmas.domain.Menus;
import christmas.domain.OrderMenus;
import christmas.domain.VisitDate;
import christmas.util.Parse;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Menus menus;

    public EventController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        menus = new Menus();
    }

    public void run() {
        VisitDate visitDate = getVisitDate();
        OrderMenus orderMenus = getOrderMenus();
    }

    private VisitDate getVisitDate() {
        return VisitDate.create(Parse.parseInt(inputView.readVisitDate()));
    }

    private OrderMenus getOrderMenus() {
        return OrderMenus.from(inputView.readOrderMenu());
    }

}
