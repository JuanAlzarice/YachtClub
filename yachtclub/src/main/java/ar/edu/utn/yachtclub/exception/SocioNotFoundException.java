package ar.edu.utn.yachtclub.exception;

public class SocioNotFoundException extends RuntimeException {

    public SocioNotFoundException(Long id) {
        super("No existe un socio con ID: " + id);
    }

}
