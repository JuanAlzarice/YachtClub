package ar.edu.utn.yachtclub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado_zona")
public class EmpleadoZona {

    @EmbeddedId
    private EmpleadoZonaId id = new EmpleadoZonaId();

    @ManyToOne
    @MapsId("empleadoId")
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @MapsId("zonaId")
    @JoinColumn(name = "id_zona")
    private Zona zona;

    @Column(nullable = false)
    private Integer barcosACargo = 0;

    public EmpleadoZona() {}

    public EmpleadoZona(Empleado empleado, Zona zona, Integer barcosACargo) {
        this.empleado = empleado;
        this.zona = zona;
        this.barcosACargo = barcosACargo != null ? barcosACargo : 0;
        this.id.setEmpleadoId(empleado.getIdEmpleado());
        this.id.setZonaId(zona.getIdZona());
    }

    // Getters y setters
    public EmpleadoZonaId getId() { return id; }
    public void setId(EmpleadoZonaId id) { this.id = id; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
        if (empleado != null) this.id.setEmpleadoId(empleado.getIdEmpleado());
    }

    public Zona getZona() { return zona; }
    public void setZona(Zona zona) {
        this.zona = zona;
        if (zona != null) this.id.setZonaId(zona.getIdZona());
    }

    public Integer getBarcosACargo() {
        return barcosACargo;
    }

    public void setBarcosACargo(Integer barcosACargo) {
        this.barcosACargo = barcosACargo;
    }

}
