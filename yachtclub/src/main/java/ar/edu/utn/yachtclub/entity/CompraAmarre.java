package ar.edu.utn.yachtclub.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "compras_amarre")
public class CompraAmarre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "fecha")
    private LocalDate fechaCompra;

    @Column(name = "monto")
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "id_amarre")
    private Amarre amarre;

    public CompraAmarre() {}



    // Getters y Setters
    public Long getIdCompra() { return idCompra; }
    public void setIdCompra(Long idCompra) { this.idCompra = idCompra; }

    public LocalDate getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(LocalDate fechaCompra) { this.fechaCompra = fechaCompra; }

    public Socio getSocio() { return socio; }
    public void setSocio(Socio socio) { this.socio = socio; }

    public Amarre getAmarre() { return amarre; }
    public void setAmarre(Amarre amarre) { this.amarre = amarre; }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
}
