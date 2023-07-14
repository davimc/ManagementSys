package io.github.davimc.msExceptionHandler.exceptions;


import java.util.UUID;

//TODO criar ms para controlar exceptions e tratamento de erros
public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String id, Class<?> className) {
        super("Object not found. identifier: " + id + " to: " + className.getSimpleName());
    }
}
