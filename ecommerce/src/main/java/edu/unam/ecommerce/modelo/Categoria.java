package edu.unam.ecommerce.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase es de las Categorias de los Productos que se van a ofrecer en la pagina.
 * 
 * @version v1.0.0.2
 * @author Pluhator Nicolas
 * 
 */
@Entity
@Table(name = "categorias")
@Getter @Setter @NoArgsConstructor
public class Categoria {
    /**
     * idCategoria es el identificador unico generado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Integer idCategoria;
    
    /**
     * nombreCategoria es el nombre de la Categoria que sera mostrado en la pagina.
     */
    @NotNull
    @Column(nullable = false, length = 40)
    private String nombreCategoria;
    
    /**
     * descripcionCategoria es una descripcion opcional que se puede agregar para brindar mas informacion a los clientes.
     */
    @Column(nullable= true, length = 255)
    private String descripcionCategoria;
    
    /**
     * created_at Representa la fecha en la cual se almaceno la Categoria.
     */
    @Setter(AccessLevel.NONE)
    private LocalDateTime created_at = LocalDateTime.now();
    
    /**
     * updated_at Representa la fecha en la cual se modifico algun valor de la Categoria.
     */
    private LocalDateTime updated_at = LocalDateTime.now();
    
    /**
     * productos Representa una lista con todos los Productos que pertenecen a la Categoria.
     * @see edu.unam.ecommerce.modelo.Producto
     */
    @OneToMany (mappedBy = "categoria")
    private List<Producto> productos = new ArrayList<>();
}
