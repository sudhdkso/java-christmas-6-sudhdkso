package christmas.domain;

import christmas.domain.enums.ErrorMessage;
import christmas.util.ErrorException;
import java.util.List;

public class Menus {
    private final List<Menu> menus;

    private Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus of(List<Menu> menus) {
        return new Menus(menus);
    }

    public Menu getMenuByMenuName(String name) {
        return menus.stream()
                .filter(menu -> menu.hasSameName(name))
                .findAny()
                .orElseThrow(() -> new ErrorException(ErrorMessage.INVALID_ORDER_EXCEPTION));
    }
}
