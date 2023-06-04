package io.github.davimc.msstore.services.ex;


//TODO criar ms para controlar exceptions e tratamento de erros
public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
    public ObjectNotFoundException(Long id, Class<?> className) {
        super("Object not found. id: " + id + " to: " + className.getSimpleName());
    }
}
