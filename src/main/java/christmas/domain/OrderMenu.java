package christmas.domain;

public class OrderMenu{
    private final Menu menu;
    private final int count;

    private OrderMenu(Menu menu, int count){
        this.menu = menu;
        this.count = count;
    }

    public static OrderMenu create(Menu menu, int count){
        return new OrderMenu(menu, count);
    }
}
