package christmas.domain;

import static christmas.domain.enums.EventConstatns.ADDITIONAL_AMOUNT;
import static christmas.domain.enums.EventConstatns.EVENT_DAY_END_DATE;
import static christmas.domain.enums.EventConstatns.EVENT_END_DATE;
import static christmas.domain.enums.EventConstatns.EVENT_MONTH;
import static christmas.domain.enums.EventConstatns.EVENT_START_DATE;
import static christmas.domain.enums.EventConstatns.EVENT_YEAR;
import static christmas.domain.enums.EventConstatns.INITIAL_EVENT_THRESHOLD;

import christmas.domain.enums.ErrorMessage;
import christmas.domain.enums.EventDayOfWeeks;
import christmas.util.ErrorException;
import christmas.util.Parse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitDate {
    private int visitDate;

    private VisitDate(int visitDate) {
        validate(visitDate);
        this.visitDate = visitDate;
    }

    public static VisitDate create(String visitDate) {
        return new VisitDate(Parse.parseVisitDate(visitDate));
    }

    private void validate(int visitDate) {
        validateOutOfRangeVisitDate(visitDate);
    }

    private void validateOutOfRangeVisitDate(int visitDate) {
        if (visitDate < EVENT_START_DATE || visitDate > EVENT_END_DATE) {
            throw new ErrorException(ErrorMessage.INVALID_DATE_RETRY_EXCEPTION);
        }
    }

    public boolean isVisitDateWeekend() {
        int dayOfWeek = getDayOfWeek();
        if (EventDayOfWeeks.isWeekend(dayOfWeek)) {
            return true;
        }
        return false;
    }

    private int getDayOfWeek() {
        String day = String.format("%d-%d-%1$02d", EVENT_YEAR, EVENT_MONTH, visitDate);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(day);
            return date.getDay();
        } catch (ParseException e) {
            throw new ErrorException(ErrorMessage.NUMBER_FORMAT_EXCEPTION);
        }
    }

    public int getDdayDiscountByVisitDate() {
        if (isEventDay()) {
            return INITIAL_EVENT_THRESHOLD + (visitDate - 1) * ADDITIONAL_AMOUNT;
        }
        return 0;
    }

    public boolean isSpecialEventDay() {
        return SpecialDays.contains(visitDate);
    }

    public boolean isEventDay() {
        return visitDate <= EVENT_DAY_END_DATE;
    }

    public int getVisitDate() {
        return visitDate;
    }
}
