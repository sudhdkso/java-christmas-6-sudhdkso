package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.SpecialDays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialDaysTest {
    SpecialDays specialDays;

    @BeforeEach
    void setUp() {
        specialDays = SpecialDays.create();
    }

    @Test
    @DisplayName("입력받은 날짜가 별이 달린 날일 때")
    void input_date_is_special_day() {
        //given
        int day = 25;
        //when

        boolean expectedValue = true;

        //then
        assertThat(SpecialDays.contains(day))
                .isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("입력받은 날짜가 별이 달린 날이 아닐 떄")
    void input_date_is_not_special_day() {
        //given
        int day = 27;
        //when

        boolean expectedValue = false;

        //then
        assertThat(SpecialDays.contains(day))
                .isEqualTo(expectedValue);
    }
}
