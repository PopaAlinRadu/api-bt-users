package info.bill_tracker.users.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@ControllerAdvice
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

}
