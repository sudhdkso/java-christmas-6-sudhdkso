package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import christmas.domain.Menus;
import christmas.domain.OrderMenus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderMenuTest {
    private Menus menus;

    @BeforeEach
    void setUp() {
        menus = new Menus();
    }

    @Test
    @DisplayName("올바른 주문이 입력되었을 때")
    void valid_order_menu() {
        String menuInput = "티본스테이크-1,바비큐립-2,초코케이크-2,제로콜라-1";
        OrderMenus orderMenus = OrderMenus.from(menuInput);

        int expectedValue = 3;

        assertThat(orderMenus.getMainOrderCount())
                .isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("올바르지 않은 주문이 입력되었을 때")
    void invalid_order_menu() {
        //given
        String menuInput = "크리스마스파스타-";

        // when
        Throwable thrown = catchThrowable(() -> OrderMenus.from(menuInput));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문 갯수가 0개일 때 예외 발생")
    void invalid_order_menu_count() {
        //given
        String menuInput = "크리스마스파스타-0";

        // when
        Throwable thrown = catchThrowable(() -> OrderMenus.from(menuInput));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메뉴에 없는 이름으로 주문할 때 예외가 발생한다.")
    void not_fount_order_menu() {
        //given
        String menuInput = "해산물빠에야-1";

        // when
        Throwable thrown = catchThrowable(() -> OrderMenus.from(menuInput));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음료만 주문할 때 예외가 발생한다.")
    void only_drink_order() {
        //given
        String menuInput = "제로콜라-3,샴페인-1";
        // when
        Throwable thrown = catchThrowable(() -> OrderMenus.from(menuInput));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
