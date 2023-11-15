package christmas.controller;

import static christmas.util.TaskRetry.retryUntilSuccess;

import christmas.domain.EventBenefit;
import christmas.domain.Menus;
import christmas.domain.OrderMenus;
import christmas.domain.SpecialDays;
import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Menus menus = new Menus();
    private final SpecialDays specialDays = SpecialDays.create();

    public EventController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        VisitDate visitDate = getVisitDate();
        OrderMenus orderMenus = getOrderMenus();

        outputView.printOrderMenu(orderMenus.render());

        outputView.printTotalAmount(orderMenus.getTotalOrderAmount());
        EventBenefit eventBenefit = new EventBenefit(visitDate, orderMenus);

        printEventBenefit(eventBenefit, orderMenus);
    }

    private VisitDate getVisitDate() {
        return retryUntilSuccess(() ->
                VisitDate.create(inputView.readVisitDate()));
    }

    private OrderMenus getOrderMenus() {
        return retryUntilSuccess(() ->
                OrderMenus.from(inputView.readOrderMenu()));
    }

    private void printEventBenefit(EventBenefit eventBenefit, OrderMenus orderMenus) {
        outputView.printGiveAwayMenu(eventBenefit.renderGiveAway());
        outputView.printTotalBenefit(eventBenefit.render());
        outputView.printTotalBenefitAmount(eventBenefit.getTotalEventBenefitAmount());

        outputView.printTotalPaymentAmount(orderMenus.getTotalOrderAmount() - eventBenefit.getTotalDeductedAmount());
    }

}
