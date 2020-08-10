package info.bill_tracker.users.handlers;

import com.mongodb.MongoWriteException;
import info.bill_tracker.users.exceptions.BaseRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

import static java.util.stream.Collectors.*;

@ControllerAdvice
@Slf4j
public class ErrorHandlingControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException notValidException, HttpHeaders headers, HttpStatus status, WebRequest request) {

        LinkedHashMap<String, List<String>> errors = notValidException.getBindingResult().getAllErrors()
                .stream()
                .map(CustomError::new)
                .collect(toList())
                .stream()
                .collect(groupingBy(CustomError::getFieldName, LinkedHashMap::new, mapping(CustomError::getErrorMessage, toList())));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ MongoWriteException.class })
    public ResponseEntity<Object> handleMongoWriteException(Exception ex, WebRequest request) {
        String message = ex.getCause().getMessage();
        CustomError customError = new CustomError("mongo exception", message);
        log.debug("Operation failed :: {}", message);
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ BaseRuntimeException.class })
    public ResponseEntity<Object> handleBaserException(Exception ex, WebRequest request) {
        CustomError customError = ((BaseRuntimeException) ex).getCustomError();
        log.debug("Operation failed :: {}", customError);
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }

}
