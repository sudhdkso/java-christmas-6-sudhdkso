package christmas.domain.enums;

import java.util.Arrays;

public enum MenuType {
    EMPTY("없음"),
    BEVERAGE("음료"),
    APPETIZER("에피타이저"),
    DESSERT("디저트"),
    MAIN("메인");

    private final String name;

    MenuType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static MenuType getMenuTypeByName(String name) {
        return Arrays.stream(values())
                .filter(menuType -> menuType.getName().equals(name))
                .findAny()
                .orElse(MenuType.EMPTY);
    }
}
