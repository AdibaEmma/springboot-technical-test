package com.aweperi.agpaytechtechnicaltest.exceptions;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
       @NonNull HttpHeaders headers, HttpStatus status, @NonNull WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all exceptions
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(value = CountryNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage countryNotFoundException(CountryNotFoundException ex) {
        log.error(ex.getMessage());
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), "Country Not Found Error", ex.getMessage());
    }

    @ExceptionHandler(value = CountryAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage countriesNotFoundException(CountryAlreadyExistsException ex) {
        log.error(ex.getMessage());
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), "Existing Country Entity Error", ex.getMessage());
    }

    @ExceptionHandler(value = IllegalPopulationSizeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage illegalPopulationSizeException(IllegalPopulationSizeException ex) {
        log.error(ex.getMessage());
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), new Date(),
                "Zero or Negative Population Size Error", ex.getCause().getMessage());
    }

    @ExceptionHandler(value = ClassNotFoundException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage classNotFoundException(ClassNotFoundException ex) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                "An unknown error occurred",
                ex.getMessage());
    }
}
