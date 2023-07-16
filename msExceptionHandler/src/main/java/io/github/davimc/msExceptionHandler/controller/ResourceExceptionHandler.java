package io.github.davimc.msExceptionHandler.controller;

import io.github.davimc.msExceptionHandler.controller.responses.StandardError;
import io.github.davimc.msExceptionHandler.controller.responses.ValidationError;
import io.github.davimc.msExceptionHandler.exceptions.ObjectNotFoundException;
import io.github.davimc.msExceptionHandler.exceptions.SimpleGlobalException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();
        err.setTimeStamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError();
        err.setTimeStamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        e.getBindingResult().getFieldErrors().stream()
                .forEach(f -> err.addError(f.getField(), f.getDefaultMessage()));

        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(SimpleGlobalException.class)
    public ResponseEntity<StandardError> simpleGlobalException(SimpleGlobalException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimeStamp(Instant.now());
        err.setStatus(e.getStatus().value());
        err.setError(e.getError());
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(err.getStatus()).body(err);
    }
}
