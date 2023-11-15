package christmas.service;

import christmas.domain.OrderMenus;
import christmas.domain.VisitDate;

public class EventService {
    private VisitDate visitDate;
    private OrderMenus orderMenus;

    public EventService(final VisitDate visitDate, final OrderMenus orderMenus) {
        this.visitDate = visitDate;
        this.orderMenus = orderMenus;
    }
    
}
