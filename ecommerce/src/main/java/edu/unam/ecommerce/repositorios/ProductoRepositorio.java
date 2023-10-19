package edu.unam.ecommerce.repositorios;

import edu.unam.ecommerce.modelo.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Este es el repositorio encargado de la comunicacion con la tabla de Productos.
 * 
 * @version v1.0.0.2
 * @author Pluhator Nicolas
 * 
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    /**
    * Es una funcion que me traera todos aquellos Productos que no tengan estado en "false"
    * 
    * @param estado Representa los Productos que debe traer con el estado pasado por parametro.
    * @return Devuelve una lista de todos los Productos.
    */
    List<Producto> findAllByEstado(boolean estado);
}
