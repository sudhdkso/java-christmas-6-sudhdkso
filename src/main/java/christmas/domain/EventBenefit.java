package christmas.domain;

import static christmas.domain.enums.EventConstatns.SPECIAL_DAY_DISCOUNT_AMOUNT;

import christmas.domain.enums.BenefitType;
import java.util.EnumMap;

public class EventBenefit {
    private static final String GIVE_AWAY_MENU_NAME = "샴페인";
    private static final Menu giveAwayMenu = Menus.getMenuByMenuName(GIVE_AWAY_MENU_NAME);
    private static final int GIVE_AWAY_COUNT = 1;
    private static final String EMPTY = "없음";
    private static EnumMap<BenefitType, Integer> eventBenefit;

    public EventBenefit(VisitDate visitDate, OrderMenus orderMenus) {
        eventBenefit = new EnumMap<>(BenefitType.class);
        if (orderMenus.isEligibleForBenefit()) {
            getEventBenefit(visitDate, orderMenus);
        }
    }

    private void getEventBenefit(VisitDate visitDate, OrderMenus orderMenus) {
        caculateDdayDiscount(visitDate);
        caculateWeekDiscount(visitDate, orderMenus);
        caculateSpecialDiscount(visitDate);
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

    private void caculateSpecialDiscount(VisitDate visitDate) {
        if (visitDate.isSpecialEventDay()) {
            eventBenefit.put(BenefitType.SPECIAL, SPECIAL_DAY_DISCOUNT_AMOUNT);
        }
    }

    private void caculateWeekendDiscount(OrderMenus orderMenus) {
        eventBenefit.put(BenefitType.WEEKEND, orderMenus.getMainOrderCount() * 2023);
    }

    private void caculateGiveAway(OrderMenus orderMenus) {
        if (orderMenus.isEligibleForGiveAway()) {
            eventBenefit.put(BenefitType.GIVEAWY, giveAwayMenu.getAmount());
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

    private boolean hasGiveWay() {
        return eventBenefit.containsKey(BenefitType.GIVEAWY);
    }

    public int getTotalEventBenefitAmount() {
        return caculateTotalEventBenefitAmount();
    }

    public int getTotalDeductedAmount() {
        return caculateTotalDeductedAmount();
    }

    private String renderBenefitEmpty() {
        return new String(EMPTY);
    }

    public String renderGiveAway() {
        StringBuilder sb = new StringBuilder();
        if (hasGiveWay()) {
            sb.append(String.format("%s %d개\n", giveAwayMenu.getName(), GIVE_AWAY_COUNT));
            return sb.toString();
        }

        return renderBenefitEmpty();
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        if (isBenefitEmpty()) {
            return renderBenefitEmpty();
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
