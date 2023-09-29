package edu.unam.ecommerce.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Integer idProd;
    
    @Column(nullable = false, length = 40)
    private String nombreProd;
    
    @Column(nullable = true, length = 100)
    private String descProd;
    
    @Column(nullable = false, length = 40)
    private String categProd;
    private Float precioProd;
    private Integer cantProd;
}
