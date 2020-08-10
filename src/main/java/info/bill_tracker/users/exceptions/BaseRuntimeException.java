package info.bill_tracker.users.exceptions;

import info.bill_tracker.users.handlers.CustomError;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseRuntimeException extends RuntimeException {

    private final CustomError customError;

    public BaseRuntimeException(CustomError customError){
        this.customError = customError;
    }

}
