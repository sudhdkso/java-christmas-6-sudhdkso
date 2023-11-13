package christmas.domain.enums;

public enum MenuInfo {
    BUTTON_MUSHROOM_SOUP("양송이수프", MenuType.APPETIZER, 6_000),
    TAPAS("타파스", MenuType.APPETIZER, 5_500),
    CAESAR_SALAD("시저샐러드", MenuType.APPETIZER, 8_000),

    TBONE_STREAK("티본스테이크", MenuType.MAIN, 55_000),

    BARBECUE_RIBS("바비큐립", MenuType.MAIN, 54_000),
    SEAFOOD_PASTA("해산물파스타", MenuType.MAIN, 35_000),
    XMAS_PASTA("크리스마스파스타", MenuType.MAIN, 25_000),

    CHOCOLATE_CAKE("초코케이크", MenuType.DESSERT, 15_000),
    ICECREAM("아이스크림", MenuType.DESSERT, 5_000),

    ZERO_COKE("제로콜라", MenuType.BEVERAGE, 3_000),
    RED_WINE("레드와인", MenuType.BEVERAGE, 60_000),
    CHAMPAGNE("샴페인", MenuType.BEVERAGE, 25_000);


    private final String name;
    private final MenuType menuType;
    private final int cost;

    MenuInfo(String name, MenuType menuType, int cost) {
        this.name = name;
        this.menuType = menuType;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public int getCost() {
        return cost;
    }
}
