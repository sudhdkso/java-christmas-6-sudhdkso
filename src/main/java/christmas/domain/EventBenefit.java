package christmas.domain;

import christmas.domain.enums.BenefitType;
import christmas.domain.enums.MenuInfo;
import java.util.EnumMap;

public class EventBenefit {
    private static EnumMap<BenefitType, Integer> eventBenefit;

    public EventBenefit(VisitDate visitDate, OrderMenus orderMenus) {
        eventBenefit = new EnumMap<>(BenefitType.class);
        if (orderMenus.isEligibleForBenefit()) {
            setEventBenefit(visitDate, orderMenus);
        }
    }

    private void setEventBenefit(VisitDate visitDate, OrderMenus orderMenus) {
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
        if (orderMenus.isEligibleForGiveAway()) {
            eventBenefit.put(BenefitType.GIVEAWY, MenuInfo.CHAMPAGNE.getCost());
        }
    }

    private static int getBenefitAmountByBenefitType(BenefitType benefitType) {
        return eventBenefit.get(benefitType);
    }

    private boolean isBenefitEmpty() {
        return eventBenefit.isEmpty();
    }

    private int caculateTotalEventBenefitAmount() {
        return eventBenefit.keySet()
                .stream()
                .mapToInt(EventBenefit::getBenefitAmountByBenefitType)
                .sum() * (-1);
    }

    private int caculateTotalDeductedAmount() {
        return eventBenefit.keySet()
                .stream()
                .filter(benefitType -> !benefitType.equals(BenefitType.GIVEAWY))
                .mapToInt(EventBenefit::getBenefitAmountByBenefitType)
                .sum();
    }

    public int getTotalEventBenefitAmount() {
        return caculateTotalEventBenefitAmount();
    }

    public int getTotalDeductedAmount() {
        return caculateTotalDeductedAmount();
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        if (isBenefitEmpty()) {
            sb.append("없음\n");
            return sb.toString();
        }
        
        eventBenefit.keySet()
                .forEach(benefit -> {
                    String name = benefit.getName();
                    int amount = getBenefitAmountByBenefitType(benefit);
                    sb.append(String.format("%s : -%,d원\n", name, amount));
                });
        return sb.toString();
    }
}
