package edu.unam.ecommerce.repositorios;

import edu.unam.ecommerce.modelo.Proveedor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Este es el repositorio encargado de la comunicacion con la tabla de
 * Proveedores.
 * 
 * @version v1.0.0.7
 * @author Pluhator Nicolas
 * 
 */
@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer> {
    /**
     * Retornara un listado de proveedores segun su estado.
     * 
     * @param estado Representa si esta activo o dado de baja.
     * @return Listado de Proveedores segun el estado pasado por parametro.
     */
    public List<Proveedor> findAllByEstado(boolean estado);
}
