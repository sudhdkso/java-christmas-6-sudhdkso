package christmas.domain;

public class OrderMenu{
    private final Menu menu;
    private final OrderCount orderCount;

    private OrderMenu(Menu menu, OrderCount orderCount){
        this.menu = menu;
        this.orderCount = orderCount;
    }

    public static OrderMenu create(Menu menu, int count){
        return new OrderMenu(menu, new OrderCount(count));
    }

    private int getOrderCount(){
        return orderCount.count();
    }
}
