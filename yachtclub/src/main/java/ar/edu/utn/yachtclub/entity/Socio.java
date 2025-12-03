
package ar.edu.utn.yachtclub.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "socios")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private Long id;

    @NotBlank(message = "Los nombres son obligatorios")
    @Size(min = 2, max = 100, message = "Los nombres deben tener entre 2 y 100 caracteres")
    private String nombre;
    
    
    private String direccion;

    @NotNull(message = "El DNI es obligatorio")
    @Min(value = 10000000, message = "El DNI debe tener al menos 8 dígitos")
    @Max(value = 999999999, message = "El DNI no puede tener más de 9 dígitos")
    @Column(unique = true)
    private String dni;

    private String telefono;
    
    
    @Past(message = "La fecha de nacimiento debe ser anterior a hoy")
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
