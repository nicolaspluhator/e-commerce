package edu.unam.ecommerce.repositorios;

import edu.unam.ecommerce.modelo.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    List<Producto> findAllByEstado(boolean estado);
}
