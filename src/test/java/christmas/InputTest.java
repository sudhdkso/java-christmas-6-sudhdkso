package christmas;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import christmas.domain.enums.ErrorMessage;
import christmas.util.BudgetValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {

    @ParameterizedTest
    @ValueSource(strings = {"30000", "1", "495076"})
    @DisplayName("정상 입력")
    void valid_input(String input) {
        assertThatCode(() -> BudgetValidator.validate(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"222111111111111", "111111111111"})
    @DisplayName("int 범위를 초과한 입력의 경우 예외가 발생한다.")
    void input_overflow_int_range(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BudgetValidator.validate(input))
                .withMessageStartingWith(ErrorMessage.OVERFLOW_INT_RANGE_EXCEPTION.getMessage());
    }
    
}
