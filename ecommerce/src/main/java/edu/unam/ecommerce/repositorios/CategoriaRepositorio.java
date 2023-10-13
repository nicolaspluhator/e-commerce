package edu.unam.ecommerce.repositorios;

import edu.unam.ecommerce.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer>{
    
}
