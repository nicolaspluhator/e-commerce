package edu.unam.ecommerce.repositorios;

import edu.unam.ecommerce.modelo.Tipo;
import edu.unam.ecommerce.modelo.Transaccion;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de la clase Transaccion.
 * 
 * @version v1.0.0.4
 * @author Pluhator Nicolas
 */
@Repository
public interface TransaccionRepositorio extends JpaRepository<Transaccion, Integer> {

    /**
     * Esta funcion devolvera todas las transacciones segun su estado.
     * Los estados posibles son: COMPRA - VENTA
     * 
     * @param tipo donde puede ser COMPRA O VENTA.
     * @return Listado de Transacciones
     */
    List<Transaccion> findAllByTipo(Tipo tipo);
}
