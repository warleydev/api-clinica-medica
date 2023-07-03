package com.warleydev.apimedic.controllers.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validationError(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationError err = new ValidationError();
        err.setTimestamp(Instant.now());
        err.setPath(request.getRequestURI());
        err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        err.setMessage(e.getMessage());
        err.setError("Erro de validação!");

        e.getBindingResult().getFieldErrors().forEach(f -> err.addError(f.getField(), f.getDefaultMessage()));
        return ResponseEntity.status(err.getStatus()).body(err);
    }

}
