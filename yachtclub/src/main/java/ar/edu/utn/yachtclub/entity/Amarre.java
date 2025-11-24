package ar.edu.utn.yachtclub.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "amarres")
public class Amarre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAmarre;

    @Column(unique = true, nullable = false)
    private Integer numero;

    private Double lecturaAgua;
    private Double lecturaLuz;
    private Boolean mantenimiento = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "id_zona")
    private Zona zona;

    @OneToOne(mappedBy = "amarre", cascade = CascadeType.ALL)
    private Embarcacion embarcacion;

    @OneToMany(mappedBy = "amarre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompraAmarre> compras = new ArrayList<>();

    public Amarre() {
    }

    // Getters y Setters
    public Long getIdAmarre() {
        return idAmarre;
    }

    public void setIdAmarre(Long idAmarre) {
        this.idAmarre = idAmarre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getLecturaAgua() {
        return lecturaAgua;
    }

    public void setLecturaAgua(Double lecturaAgua) {
        this.lecturaAgua = lecturaAgua;
    }

    public Double getLecturaLuz() {
        return lecturaLuz;
    }

    public void setLecturaLuz(Double lecturaLuz) {
        this.lecturaLuz = lecturaLuz;
    }

    public Boolean getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Embarcacion getEmbarcacion() {
        return embarcacion;
    }

    public void setEmbarcacion(Embarcacion embarcacion) {
        this.embarcacion = embarcacion;
    }

    public List<CompraAmarre> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraAmarre> compras) {
        this.compras = compras;
    }
}
