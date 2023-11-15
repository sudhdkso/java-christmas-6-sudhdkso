package christmas.domain;

import static christmas.domain.enums.EventConstatns.EVENT_END_DATE;
import static christmas.domain.enums.EventConstatns.EVENT_START_DATE;

import christmas.domain.enums.ErrorMessage;
import christmas.util.ErrorException;
import christmas.util.ResourceReader;
import java.util.List;
import java.util.stream.Collectors;

public class SpecialDays {
    private static List<Integer> specialDays;

    private SpecialDays(List<Integer> specialDays) {
        this.specialDays = getIntegerSpecialDays();
        validate();
    }

    public static SpecialDays create() {
        return new SpecialDays(getIntegerSpecialDays());
    }

    private void validate() {
        validateDays();
    }

    private void validateDays() {
        specialDays.stream()
                .forEach(day -> isValidDay(day));
    }

    private void isValidDay(int day) {
        if (day < EVENT_START_DATE || day > EVENT_END_DATE) {
            throw new ErrorException(ErrorMessage.INVALID_DATE_EXCEPTION);
        }
    }

    public static boolean contains(int visitDate) {
        return specialDays.contains(visitDate);
    }

    private static List<String> readSpecialDays() {
        return ResourceReader.readResource("src/main/resources/special-day.md");
    }

    private static List<Integer> getIntegerSpecialDays() {
        return readSpecialDays()
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
