package edu.unam.ecommerce.modelo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    
    @NotNull
    @Column(nullable = false, length = 40)
    private String nombreCategoria;
    
    @Column(nullable= true, length = 255)
    private String descripcionCategoria;
    
    @Setter(AccessLevel.NONE)
    private LocalDateTime created_at = LocalDateTime.now();
    
    private LocalDateTime updated_at = LocalDateTime.now();
    
    @OneToMany (mappedBy = "categoria")
    private List<Producto> productos = new ArrayList<>();
}
