package ar.edu.utn.yachtclub.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmpleadoZonaId implements Serializable {

    private Long empleadoId;
    private Long zonaId;

    public EmpleadoZonaId() {}

    public EmpleadoZonaId(Long empleadoId, Long zonaId) {
        this.empleadoId = empleadoId;
        this.zonaId = zonaId;
    }

    // Getters y setters
    public Long getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(Long empleadoId) { this.empleadoId = empleadoId; }

    public Long getZonaId() { return zonaId; }
    public void setZonaId(Long zonaId) { this.zonaId = zonaId; }

    // hashCode y equals (crucial para @EmbeddedId)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmpleadoZonaId)) return false;
        EmpleadoZonaId that = (EmpleadoZonaId) o;
        return Objects.equals(empleadoId, that.empleadoId) &&
               Objects.equals(zonaId, that.zonaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleadoId, zonaId);
    }
}
