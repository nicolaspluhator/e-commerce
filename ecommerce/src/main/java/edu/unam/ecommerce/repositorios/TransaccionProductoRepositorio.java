package edu.unam.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unam.ecommerce.modelo.TransaccionProducto;

/**
 * Repositorio de la clase TransaccionProducto.
 * 
 * @version v1.0.0.4
 * @author Pluhator Nicolas
 */
@Repository
public interface TransaccionProductoRepositorio extends JpaRepository<TransaccionProducto, Integer> {

}
