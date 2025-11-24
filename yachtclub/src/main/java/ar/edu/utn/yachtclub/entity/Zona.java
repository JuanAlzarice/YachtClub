package ar.edu.utn.yachtclub.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zonas")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private Long idZona;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(name = "precio_mensual")
    private Double precioMensual;

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL)
    private List<Amarre> amarres = new ArrayList<>();

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL)
    private List<EmpleadoZona> empleadoZonas = new ArrayList<>();

    public Zona() {}

    // Getters y setters
    public Long getIdZona() { return idZona; }
    public void setIdZona(Long idZona) { this.idZona = idZona; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecioMensual() { return precioMensual; }
    public void setPrecioMensual(Double precioMensual) { this.precioMensual = precioMensual; }

    public List<Amarre> getAmarres() { return amarres; }
    public void setAmarres(List<Amarre> amarres) { this.amarres = amarres; }

    public List<EmpleadoZona> getEmpleadoZonas() { return empleadoZonas; }
    public void setEmpleadoZonas(List<EmpleadoZona> empleadoZonas) { this.empleadoZonas = empleadoZonas; }
}
