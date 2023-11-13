package christmas.domain;

import static christmas.domain.enums.EventConstatns.EVENT_END_DATE;
import static christmas.domain.enums.EventConstatns.EVENT_MONTH;
import static christmas.domain.enums.EventConstatns.EVENT_START_DATE;
import static christmas.domain.enums.EventConstatns.EVENT_YEAR;

import christmas.domain.enums.ErrorMessage;
import christmas.domain.enums.EventDayOfWeeks;
import christmas.util.ErrorException;
import java.util.Date;

public class VisitDate {
    private int visitDate;

    private VisitDate(int visitDate){
        validate(visitDate);
        this.visitDate = visitDate;
    }

    public static VisitDate create(int visitDate){
        return new VisitDate(visitDate);
    }

    private void validate(int visitDate){
        validateOutOfRangeVisitDate(visitDate);
    }

    public boolean isVisitDateWeekend(){
        int dayOfWeek = getDayOfWeek();
        if(EventDayOfWeeks.isWeekend(dayOfWeek)) {
            return true;
        }
        return false;
    }

    private int getDayOfWeek(){
        Date date = new Date(String.format("%d-%d-%d",EVENT_YEAR, EVENT_MONTH, visitDate));
        return date.getDay();
    }

    private void validateOutOfRangeVisitDate(int visitDate){
        if(visitDate < EVENT_START_DATE || visitDate > EVENT_END_DATE){
            throw new ErrorException(ErrorMessage.INVALID_DATE_EXCEPTION);
        }
    }

}
