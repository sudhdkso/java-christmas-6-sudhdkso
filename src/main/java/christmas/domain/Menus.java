package christmas.domain;

import christmas.domain.enums.ErrorMessage;
import christmas.domain.enums.MenuInfo;
import christmas.util.ErrorException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menus {
    private static List<Menu> menus;

    public Menus() {
        this.menus = setMenus();
    }

    public static Menu getMenuByMenuName(String name) {
        return menus.stream()
                .filter(menu -> menu.hasSameName(name))
                .findAny()
                .orElseThrow(() -> new ErrorException(ErrorMessage.INVALID_ORDER_EXCEPTION));
    }

    private static List<Menu> setMenus() {
        return Arrays.stream(MenuInfo.values())
                .map(menu -> new Menu(menu.getName(), menu.getMenuType(), menu.getCost()))
                .collect(Collectors.toList());
    }
}
