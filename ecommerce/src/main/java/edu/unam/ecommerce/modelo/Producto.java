package edu.unam.ecommerce.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter @Setter @NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Integer idProducto;
    
    @NotNull
    @Size(max = 40)
    @Column(length = 40)
    private String nombreProducto;
    
    @NotBlank
    @Size(min = 3, max= 255)
    @Column(length = 255)
    private String descripcionProducto;
    
    @NotNull
    @Size(max = 40)
    @Column(length = 40)
    private String marcaProducto;
    
    @NotNull
    private Integer stock;
    
    @NotBlank
    @Size(min = 5, max= 30)
    private String SKU;
    
    @Column(nullable = false)
    private boolean estado = true;
    
    @NotNull
    private float precio;
    
    @Column(nullable= true)
    private String imagen;
    
    @Setter(AccessLevel.NONE)
    private LocalDateTime created_at = LocalDateTime.now();
    
    private LocalDateTime updated_at = LocalDateTime.now();
    
    @NotNull
    @ManyToOne
    @JoinColumn (name="categoria", nullable= false)
    private Categoria categoria;
    
    /*
    @OneToMany (mappedBy = "producto")
    private List<Precio> precios = new ArrayList<>();
    */
}
