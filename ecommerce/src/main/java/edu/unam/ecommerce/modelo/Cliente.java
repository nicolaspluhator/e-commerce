package edu.unam.ecommerce.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase es el modelo de Clientes.
 * 
 * @version v1.0.0.7
 * @author Pluhator Nicolas
 * 
 */
@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
public class Cliente implements Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Integer idCliente;
    @NotEmpty(message = "El nombre del cliente es requerido")
    @Size(max = 40)
    @Column(length = 40)
    private String nombreCliente;
    @NotEmpty(message = "El apellido del cliente es requerido")
    private String apellidoCliente;
    @NotEmpty(message = "El dni del cliente es requerido")
    @Size(min = 8, max = 10, message = "El documento debe tener al menos 8 numeros")
    private String dniCliente;
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email no puede ser vacio")
    private String emailCliente;
    @NotEmpty(message = "La direccion del cliente es requerida")
    private String direccionCliente;
    @NotEmpty(message = "El telefono es requerido.")
    private String telefonoCliente;
    @OneToMany(mappedBy = "cliente")
    private List<Transaccion> transaccionesCliente = new ArrayList<>();
    @Setter(AccessLevel.NONE)
    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at = LocalDateTime.now();

    @Column(nullable = false)
    private boolean estado = false;

    @Override
    public Integer getId() {
        return this.idCliente;
    }

    @Override
    public String getNombre() {
        return this.nombreCliente;
    }

    @Override
    public String getTelefono() {
        return this.telefonoCliente;
    }

    @Override
    public List<Transaccion> getTransacciones() {
        return this.transaccionesCliente;
    }

    @Override
    public boolean getEstado() {
        return this.estado;
    }

}
