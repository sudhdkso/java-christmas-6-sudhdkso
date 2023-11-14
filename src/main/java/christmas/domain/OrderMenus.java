package christmas.domain;

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
        return (int) orderMenus.stream()
                .filter(orderMenu -> orderMenu.isMenuType(MenuType.BEVERAGE))
                .count();
    }

    public int getDessertCount() {
        return (int) orderMenus.stream()
                .filter(orderMenu -> orderMenu.isMenuType(MenuType.DESSERT))
                .count();
    }

    public int getMainCount() {
        return (int) orderMenus.stream()
                .filter(orderMenu -> orderMenu.isMenuType(MenuType.MAIN))
                .count();
    }

    public int getTotalOrderCost() {
        return calculateTotalOrderCost();
    }

    private int calculateTotalOrderCost() {
        return orderMenus.stream()
                .mapToInt(OrderMenu::getTotalOrderMenuCost)
                .sum();
    }
}
