package christmas.domain;

import christmas.domain.enums.ErrorMessage;
import christmas.util.ErrorException;
import christmas.util.Parse;
import christmas.util.ResourceReader;
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
                .orElseThrow(() -> new ErrorException(ErrorMessage.INVALID_ORDER_RETRY_EXCEPTION));
    }

    private static List<String> readMenusInfo() {
        return ResourceReader.readResource("src/main/resources/menu-info.md");
    }

    private static List<Menu> setMenus() {
        return readMenusInfo()
                .stream()
                .map(menu -> Parse.splitMenu(menu))
                .collect(Collectors.toList());
    }
}
