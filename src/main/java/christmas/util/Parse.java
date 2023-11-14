package christmas.util;

import christmas.domain.Menu;
import christmas.domain.Menus;
import christmas.domain.OrderMenu;
import christmas.domain.enums.ErrorMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parse {
    private final static String DELIMETER = ",";
    private final static String SEPERATOR = "-";

    private Parse() {
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ErrorException(ErrorMessage.NUMBER_FORMAT_EXCEPTION);
        }

    }

    private static List<String> parseOrderMenu(String input) {
        return Arrays.stream(input.split(DELIMETER))
                .toList();
    }

    public static List<OrderMenu> separateOrderMenu(String input) {
        List<OrderMenu> orderMenus = new ArrayList<>();
        List<String> parseMenu = parseOrderMenu(input);

        return parseMenu.stream()
                .map(menu -> splitOrderMenu(input))
                .collect(Collectors.toList());
    }

    private static OrderMenu splitOrderMenu(String input) {
        Pattern pattern = Pattern.compile("([^-]+)-(-?\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            Menu menu = Menus.getMenuByMenuName(matcher.group(1));
            int count = parseInt(matcher.group(2));
            return OrderMenu.of(menu, count);
        }
        throw new ErrorException(ErrorMessage.INVALID_ORDER_EXCEPTION);
    }
}
