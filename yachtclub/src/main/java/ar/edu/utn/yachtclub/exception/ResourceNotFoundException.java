package ar.edu.utn.yachtclub.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, Object id) {
        super(resource + " con ID " + id + " no fue encontrado.");
    }
}
