package christmas.controller;

import christmas.domain.Menus;
import christmas.domain.OrderMenus;
import christmas.domain.VisitDate;
import christmas.service.EventService;
import christmas.util.Parse;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Menus menus = new Menus();
    private EventService eventService;

    public EventController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        VisitDate visitDate = getVisitDate();
        OrderMenus orderMenus = getOrderMenus();

        eventService = new EventService(visitDate, orderMenus);
    }

    private VisitDate getVisitDate() {
        return VisitDate.create(Parse.parseInt(inputView.readVisitDate()));
    }

    private OrderMenus getOrderMenus() {
        return OrderMenus.from(inputView.readOrderMenu());
    }

}
