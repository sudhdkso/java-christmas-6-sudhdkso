package christmas.domain;

import christmas.domain.enums.MenuType;
import java.util.Objects;

public class OrderMenu {
    private final Menu menu;
    private final OrderCount orderCount;

    private OrderMenu(Menu menu, OrderCount orderCount) {
        this.menu = menu;
        this.orderCount = orderCount;
    }

    public static OrderMenu of(Menu menu, int count) {
        return new OrderMenu(menu, new OrderCount(count));
    }

    public int getOrderCount() {
        return orderCount.count();
    }

    public int getTotalOrderAmount() {
        return menu.getAmount() * getOrderCount();
    }

    public boolean isMenuType(MenuType anotherMenuType) {
        return menu.isMenuType(anotherMenuType);
    }

    public String render() {
        return String.format("%s %d개", menu.getName(), getOrderCount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderMenu orderMenu = (OrderMenu) o;
        return Objects.equals(menu, orderMenu.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, orderCount);
    }
}
