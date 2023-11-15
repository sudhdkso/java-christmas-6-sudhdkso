package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import christmas.domain.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VisitDateTest {
    @Test
    @DisplayName("올바른 방문날짜를 입력받았을 때")
    void valid_visit_date() {
        //given
        String day = "25";
        //when
        VisitDate visitDate = VisitDate.create(day);

        boolean expectedValue = true;

        //then
        assertThat(visitDate.isEventDay())
                .isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("올바르지 않은 방문날짜를 입력받았을 때 예외 발생")
    void invalid_visit_date() {
        //given
        String day = "-1";
        // when
        Throwable thrown = catchThrowable(() -> VisitDate.create(day));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("크리스마스 디데이 이벤트 이후 방문일 때")
    void not_event_day_visit_date() {
        //given
        String day = "26";
        //when
        VisitDate visitDate = VisitDate.create(day);

        boolean expectedValue = false;

        //then
        assertThat(visitDate.isEventDay())
                .isEqualTo(expectedValue);
    }
}
