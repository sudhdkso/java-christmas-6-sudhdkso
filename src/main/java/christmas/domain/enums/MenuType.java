package christmas.domain.enums;

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
}
