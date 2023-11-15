package christmas.util;

import christmas.domain.enums.ErrorMessage;

public class ErrorException extends IllegalArgumentException{
    public ErrorException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
    }
}
