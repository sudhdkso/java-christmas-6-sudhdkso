package christmas.domain.enums;

import java.util.Arrays;

public enum
EventDayOfWeeks {
    EMPTY(0,false),
    MON(1,false),
    TUE(2,false),
    WED(3, false),
    THU(4, false),
    FRI(5,true),
    SAT(6,true),
    SUN(7,false);
    private final int dayOfWeek;
    private final boolean isWeekend;

    EventDayOfWeeks(int dayOfWeek, boolean isWeekend){
        this.dayOfWeek = dayOfWeek;
        this.isWeekend = isWeekend;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public static boolean isWeekend(int date){
        return getEventDayOfWeeks(date).isWeekend;
    }

    private static EventDayOfWeeks getEventDayOfWeeks(int date){
        return Arrays.stream(values())
                .filter(dayOfWeek -> dayOfWeek.dayOfWeek == date)
                .findAny()
                .orElse(EMPTY);
    }
}
