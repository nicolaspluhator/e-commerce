package edu.unam.ecommerce.repositorios;

import edu.unam.ecommerce.modelo.Precio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioRepositorio extends JpaRepository<Precio, Integer>{
    
}
