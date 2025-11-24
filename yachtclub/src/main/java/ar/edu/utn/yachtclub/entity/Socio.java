
package ar.edu.utn.yachtclub.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "socios")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private Long id;

    private String nombre;
    private String direccion;

    @Column(unique = true)
    private String dni;

    private String telefono;
    private LocalDate fechaIngreso;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Embarcacion> embarcaciones;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<CompraAmarre> compras;

    // getters y setters
    // constructor vacío
    public Socio() {
    }

    public Long getIdSocio() {
        return id;
    }

    public void setIdSocio(Long idSocio) {
        this.id = idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Embarcacion> getEmbarcaciones() {
        return embarcaciones;
    }

    public void setEmbarcaciones(List<Embarcacion> embarcaciones) {
        this.embarcaciones = embarcaciones;
    }

    public List<CompraAmarre> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraAmarre> compras) {
        this.compras = compras;
    }

}
