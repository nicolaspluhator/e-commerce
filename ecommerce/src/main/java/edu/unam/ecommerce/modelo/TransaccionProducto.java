package edu.unam.ecommerce.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Esta clase representara los renglones pertenecientes a una transaccion.
 * 
 * @version v1.0.0.4
 * @author Pluhator Nicolas
 */
@Entity
@Table(name = "renglones")
@Getter
@Setter
@NoArgsConstructor
public class TransaccionProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Integer idTP;
    @NotNull
    private float precioUnidad;
    @NotNull
    private Integer cantidad;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "transaccion", nullable = false)
    private Transaccion transaccion;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    /**
     * Devuelve el total del renglon.
     * 
     * @return float.
     */
    public float getTotal() {
        return (this.getPrecioUnidad() * this.getCantidad());
    }
}
