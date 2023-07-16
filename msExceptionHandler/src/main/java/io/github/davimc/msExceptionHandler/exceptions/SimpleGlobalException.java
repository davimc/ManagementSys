package io.github.davimc.msExceptionHandler.exceptions;


import org.springframework.http.HttpStatus;

//TODO criar ms para controlar exceptions e tratamento de erros
public class SimpleGlobalException extends RuntimeException {

    private String error;
    private HttpStatus status;
    public SimpleGlobalException(String message, String error, HttpStatus status) {
        super(message);
        this.error = error;
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
