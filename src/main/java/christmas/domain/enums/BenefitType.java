package christmas.domain.enums;

public enum BenefitType {
    DDAY("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    GIVEAWY("증정 이벤트");
    private final String name;

    BenefitType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
