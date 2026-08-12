package ar.edu.utn.yachtclub.exception;

// Excepciones para mandar mensaje cuando hay duplicados
public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String message) {
        super(message);
    }
}
