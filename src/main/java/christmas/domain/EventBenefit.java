package christmas.domain;

import christmas.domain.enums.BenefitType;
import christmas.domain.enums.MenuInfo;
import java.util.EnumMap;

public class EventBenefit {
    private static EnumMap<BenefitType, Integer> eventBenefit;

    public EventBenefit(VisitDate visitDate, OrderMenus orderMenus) {
        eventBenefit = new EnumMap<>(BenefitType.class);
        caculateDdayDiscount(visitDate);
        caculateWeekDiscount(visitDate, orderMenus);
        caculateGiveAway(orderMenus);
    }

    private void caculateDdayDiscount(VisitDate visitDate) {
        int dDayDiscount = visitDate.getDdayDiscountByVisitDate();
        eventBenefit.put(BenefitType.DDAY, dDayDiscount);
    }

    private void caculateWeekDiscount(VisitDate visitDate, OrderMenus orderMenus) {
        if (visitDate.isVisitDateWeekend()) {
            caculateWeekendDiscount(orderMenus);
            return;
        }
        caculateWeekDayDiscount(orderMenus);
    }

    private void caculateWeekDayDiscount(OrderMenus orderMenus) {
        eventBenefit.put(BenefitType.WEEKDAY, orderMenus.getDessertOrderCount() * 2023);
    }

    private void caculateSpecialDiscount() {

    }

    private void caculateWeekendDiscount(OrderMenus orderMenus) {
        eventBenefit.put(BenefitType.WEEKEND, orderMenus.getMainOrderCount() * 2023);
    }

    private void caculateGiveAway(OrderMenus orderMenus) {
        if (orderMenus.isEligibleForBenefit()) {
            eventBenefit.put(BenefitType.GIVEAWY, MenuInfo.CHAMPAGNE.getCost());
        }
    }

    private int getBenefitAmountByBenefitType(BenefitType benefitType) {
        return eventBenefit.get(benefitType);
    }

    public String render() {
        StringBuilder sb = new StringBuilder();

        eventBenefit.keySet()
                .forEach(benefit -> {
                    String name = benefit.getName();
                    int amount = getBenefitAmountByBenefitType(benefit);
                    sb.append(String.format("%s : -%,d\n", name, amount));
                });
        return sb.toString();
    }
}
