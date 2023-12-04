package edu.unam.ecommerce.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Esta clase es el modelo de Proveedores.
 * 
 * @version v1.0.0.7
 * @author Pluhator Nicolas
 * 
 */
@Entity
@Table(name = "proveedores")
@Getter
@Setter
@NoArgsConstructor
public class Proveedor implements Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Integer idProveedor;
    @NotEmpty(message = "El nombre del proveedor es requerido")
    @Size(max = 40)
    @Column(length = 40)
    private String nombreProveedor;
    @NotEmpty(message = "El telefono del proveedor es requerido")
    private String telefonoProveedor;
    @OneToMany(mappedBy = "proveedor")
    private List<Transaccion> transaccionesProveedor = new ArrayList<>();
    @Size(max = 150, message = "La descripcion maxima es de 150 caracteres")
    private String descripcionProveedor;
    @Setter(AccessLevel.NONE)
    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at = LocalDateTime.now();
    @Column(nullable = false)
    private boolean estado = false;

    @Override
    public Integer getId() {
        return this.idProveedor;
    }

    @Override
    public String getNombre() {
        return this.nombreProveedor;
    }

    @Override
    public String getTelefono() {
        return this.telefonoProveedor;
    }

    @Override
    public List<Transaccion> getTransacciones() {
        return this.transaccionesProveedor;
    }

    @Override
    public boolean getEstado() {
        return this.estado;
    }

}
