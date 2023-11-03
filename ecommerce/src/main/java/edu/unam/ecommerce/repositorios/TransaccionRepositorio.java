package edu.unam.ecommerce.repositorios;

import edu.unam.ecommerce.modelo.Transaccion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de la clase Transaccion.
 * 
 * @version v1.0.0.4
 * @author Pluhator Nicolas
 */
@Repository
public interface TransaccionRepositorio extends JpaRepository<Transaccion, Integer> {

}
