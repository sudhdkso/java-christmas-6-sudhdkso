package christmas.domain;

import static christmas.domain.enums.EventConstatns.BENEFIT_MIN_ORDER_AMOUNT;
import static christmas.domain.enums.EventConstatns.MAX_ORDER_COUNT;

import christmas.domain.enums.ErrorMessage;
import christmas.domain.enums.MenuType;
import christmas.util.ErrorException;
import christmas.util.Parse;
import java.util.List;

public class OrderMenus {

    private final List<OrderMenu> orderMenus;

    private OrderMenus(List<OrderMenu> orderMenus) {
        this.orderMenus = orderMenus;
        validate();
    }

    public static OrderMenus from(String separateOrder) {
        List<OrderMenu> orderMenus = Parse.separateOrderMenu(separateOrder);
        return new OrderMenus(orderMenus);
    }

    private void validate() {
        validateMenuCount();
        validateMaxOrderCount();
    }

    private void validateMaxOrderCount() {
        if (orderMenus.size() > MAX_ORDER_COUNT) {
            throw new ErrorException(ErrorMessage.INVALID_ORDER_EXCEPTION);
        }
    }

    private void validateMenuCount() {
        if (orderMenus.size() == getBeverageCount()) {
            throw new ErrorException(ErrorMessage.INVALID_ORDER_EXCEPTION);
        }
    }

    private int getBeverageCount() {
        return orderMenus.stream()
                .filter(orderMenu -> orderMenu.isMenuType(MenuType.BEVERAGE))
                .mapToInt(OrderMenu::getOrderCount)
                .sum();
    }

    public int getDessertCount() {
        return orderMenus.stream()
                .filter(orderMenu -> orderMenu.isMenuType(MenuType.DESSERT))
                .mapToInt(OrderMenu::getOrderCount)
                .sum();
    }

    public int getMainCount() {
        return orderMenus.stream()
                .filter(orderMenu -> orderMenu.isMenuType(MenuType.MAIN))
                .mapToInt(OrderMenu::getOrderCount)
                .sum();
    }

    public int getTotalOrderCost() {
        return calculateTotalOrderCost();
    }

    private int calculateTotalOrderCost() {
        return orderMenus.stream()
                .mapToInt(OrderMenu::getTotalOrderMenuCost)
                .sum();
    }

    public boolean isEligibleForBenefit() {
        return getTotalOrderCost() >= BENEFIT_MIN_ORDER_AMOUNT;
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        orderMenus.stream()
                .forEach(menu -> sb.append(menu.render())
                        .append("\n"));
        return sb.toString();
    }
}
