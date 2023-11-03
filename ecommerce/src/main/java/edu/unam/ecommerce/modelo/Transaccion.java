package edu.unam.ecommerce.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * Esta clase representa las transacciones de los productos. Por transacciones
 * nos referimos a si es una compra o una venta.
 * 
 * @version v1.0.0.4
 * @author Pluhator Nicolas
 */
@Entity
@Table(name = "transacciones")
@Getter
@Setter
@NoArgsConstructor
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Integer idTransaccion;
    @NotNull
    @Size(max = 40)
    @Column(length = 40)
    private String nroFactura;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date fecha;

    private Estado estado = Estado.INICIADA;
    private Tipo tipo;

    @Setter(AccessLevel.NONE)
    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at = LocalDateTime.now();
    @OneToMany(mappedBy = "transaccion")
    private List<TransaccionProducto> renglones = new ArrayList<>();

    /**
     * Devuelve la suma de todos los totales de los renglones.
     * 
     * @return float resultado.
     */
    public float getTotal() {
        float resultado = 0;
        for (TransaccionProducto renglon : this.renglones) {
            resultado = resultado + renglon.getTotal();
        }
        return resultado;
    }
}
