package edu.unam.ecommerce.repositorios;

import edu.unam.ecommerce.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Este es el repositorio encargado de la comunicacion con la tabla de Categorias.
 * 
 * @version v1.0.0.2
 * @author Pluhator Nicolas
 * 
 */
@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer>{
    
}
