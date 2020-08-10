package info.bill_tracker.users.exceptions;

import info.bill_tracker.users.handlers.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends BaseRuntimeException{

    public BadRequestException(CustomError customError) {
        super(customError);
    }

}
