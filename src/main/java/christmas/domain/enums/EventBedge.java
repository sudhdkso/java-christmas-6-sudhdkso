package christmas.domain.enums;

import java.util.Arrays;

public enum EventBedge {

    EMPTY("없음", 0),
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000);
    private String name;
    private int cost;

    EventBedge(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public static String getEventBedgeByAmount(int amount) {
        return Arrays.stream(values())
                .filter(bedage -> bedage != EventBedge.EMPTY)
                .filter(bedge -> amount >= bedge.getCost())
                .findAny()
                .orElse(EMPTY)
                .getName();
    }

}
