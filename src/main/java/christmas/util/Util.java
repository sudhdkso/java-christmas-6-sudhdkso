package christmas.util;

public class Util {
    private static final String SPACE = " ";
    private static final String NON_SPACE = "";

    public static String removeSpace(String input) {
        return input.replaceAll(SPACE, NON_SPACE);
    }
}
