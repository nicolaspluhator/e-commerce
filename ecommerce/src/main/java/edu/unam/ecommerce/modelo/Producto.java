package edu.unam.ecommerce.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase es de los Productos que se van a ofrecer en la pagina.
 * 
 * @version v1.0.0.2
 * @author Pluhator Nicolas
 * 
 */
@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
public class Producto {
    /**
     * idProducto es el identificador unico generado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Integer idProducto;

    /**
     * nombreProducto es el nombre del Producto que sera mostrado en la cabecera de
     * la pagina.
     */
    @NotNull
    @Size(max = 40)
    @Column(length = 40)
    private String nombreProducto;

    /**
     * descripcionProducto es una descripcion opcional que se puede agregar para
     * brindar mas informacion a los clientes.
     */
    @NotBlank
    @Size(min = 3, max = 255)
    @Column(length = 255)
    private String descripcionProducto;

    /**
     * marcaProducto es la marca del producto.
     */
    @NotNull
    @Size(max = 40)
    @Column(length = 40)
    private String marcaProducto;

    /**
     * stock es la cantidad de Productos que se posee.
     */
    @PositiveOrZero(message = "El stock debe ser un valor mayor a cero.")
    private Integer stock;

    /**
     * SKU es el codigo unico de Producto.
     */
    @NotBlank
    @Size(min = 5, max = 30)
    private String SKU;

    /**
     * estado Representa si el estado se encuentra activo "true" o dado de baja
     * "false".
     */
    @Column(nullable = false)
    private boolean estado = true;

    /**
     * precio Representa el valor del producto.
     */
    @NotNull
    private float precio;

    /**
     * imagen es la imagen que representa el Producto a vender.
     */
    @Column(nullable = true)
    private String imagen;

    /**
     * created_at Representa la fecha en la cual se almaceno el Producto.
     */
    @Setter(AccessLevel.NONE)
    private LocalDateTime created_at = LocalDateTime.now();

    /**
     * updated_at Representa la fecha en la cual se modifico algun valor del
     * Producto.
     */
    private LocalDateTime updated_at = LocalDateTime.now();

    /**
     * categoria Representa la Categoria a la que pertenece el Producto.
     * 
     * @see edu.unam.ecommerce.modelo.Categoria
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoria", nullable = false)
    private Categoria categoria;

}
