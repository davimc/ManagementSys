package io.github.davimc.msExceptionHandler.exceptions;


import java.util.UUID;

//TODO criar ms para controlar exceptions e tratamento de erros
public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(Long id, Class<?> className) {
        super("Object not found. id: " + id + " to: " + className.getSimpleName());
    }
    public ObjectNotFoundException(UUID id, Class<?> className) {
        super("Object not found. id: " + id + " to: " + className.getSimpleName());
    }
}
