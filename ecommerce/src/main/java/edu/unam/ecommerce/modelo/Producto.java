package edu.unam.ecommerce.modelo;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    
    @Column(nullable = false, length = 40)
    private String nombreProducto;
    
    @Column(nullable = true, length = 100)
    private String descripcionProducto;
    
    @Column(nullable = false, length = 40)
    private String marcaProducto;
    
    private Integer stock;
    private String SKU;
    private boolean estado = true;
    
    @Column(nullable = true)
    private String image;
    
    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn (name="categoria", nullable= false)
    private Categoria categoria;
    
    @OneToMany (mappedBy = "producto")
    private List<Precio> precios = new ArrayList<>();
}
