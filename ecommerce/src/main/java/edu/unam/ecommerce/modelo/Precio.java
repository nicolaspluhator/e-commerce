package edu.unam.ecommerce.modelo;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "precios")
@Getter @Setter @NoArgsConstructor
public class Precio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Integer idPrecio;
    
    private float valor;
    
    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name="producto", nullable = false)
    private Producto producto;
    
}
