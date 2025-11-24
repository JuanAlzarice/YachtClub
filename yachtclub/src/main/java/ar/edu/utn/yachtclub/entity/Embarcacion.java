package ar.edu.utn.yachtclub.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "embarcaciones")
public class Embarcacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmbarcacion;

    @Column(unique = true, nullable = false)
    private String matricula;

    private String nombre;
    private String tipo;
    private Double eslora;
    private Double manga;
    private LocalDate fechaAsignacion;

    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Socio socio;

    @OneToOne
    @JoinColumn(name = "id_amarre", unique = true)
    private Amarre amarre;

    public Embarcacion() {}

    // Getters y Setters
    public Long getIdEmbarcacion() { return idEmbarcacion; }
    public void setIdEmbarcacion(Long idEmbarcacion) { this.idEmbarcacion = idEmbarcacion; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Double getEslora() { return eslora; }
    public void setEslora(Double eslora) { this.eslora = eslora; }

    public Double getManga() { return manga; }
    public void setManga(Double manga) { this.manga = manga; }

    public LocalDate getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDate fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }

    public Socio getSocio() { return socio; }
    public void setSocio(Socio socio) { this.socio = socio; }

    public Amarre getAmarre() { return amarre; }
    public void setAmarre(Amarre amarre) { this.amarre = amarre; }
}
