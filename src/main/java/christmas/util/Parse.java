package christmas.util;

import christmas.domain.enums.ErrorMessage;

public class Parse {
    private Parse(){
    }

    public static int parseInt(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new ErrorException(ErrorMessage.NUMBER_FORMAT_EXCEPTION);
        }

    }
}
