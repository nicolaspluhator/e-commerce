package edu.unam.ecommerce.repositorios;

import edu.unam.ecommerce.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Este es el repositorio encargado de la comunicacion con la tabla de
 * Clientes.
 * 
 * @version v1.0.0.7
 * @author Pluhator Nicolas
 * 
 */
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    /**
     * Retornara un listado de clientes segun su estado.
     * 
     * @param estado Representa si esta activo o dado de baja.
     * @return Listado de Clientes segun el estado pasado por parametro.
     */
    public List<Cliente> findAllByEstado(boolean estado);
}
