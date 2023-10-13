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
@Table(name = "categorias")
@Getter @Setter @NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Integer idCategoria;
    
    @Column(nullable = false, length = 40)
    private String nombreCategoria;
    
    @Column(nullable = true, length = 100)
    private String descripcionCategoria;
    
    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at = LocalDateTime.now();
    
    @OneToMany (mappedBy = "categoria")
    private List<Producto> productos = new ArrayList<>();
}
