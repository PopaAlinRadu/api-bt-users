package info.bill_tracker.users.handlers;

import lombok.Data;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Data
public class CustomError {

    private String fieldName;
    private String errorMessage;

    public CustomError(ObjectError objectError) {
        this.fieldName = ((FieldError) objectError).getField();
        this.errorMessage = objectError.getDefaultMessage();
    }

}
