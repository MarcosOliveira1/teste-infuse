package com.teste.dev.java.infuse.commons;

import com.teste.dev.java.infuse.exception.NegocioException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class ControllerAdvice {


    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiErrors handleException(Exception ex) {
        return new ApiErrors(ex.getMessage());
    }
    @ExceptionHandler(NegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(NegocioException ex) {
        return new ApiErrors(ex);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(ConstraintViolationException ex) {
        ApiErrors errors = new ApiErrors();
        ex.getConstraintViolations().forEach(error ->  errors.getErrors().add(error.getMessage()));
        return errors;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(MethodArgumentNotValidException ex) {
        return new ApiErrors(ex.getBindingResult());
    }
}
