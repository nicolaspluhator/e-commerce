package edu.unam.ecommerce.servicios;

import edu.unam.ecommerce.modelo.Categoria;
import edu.unam.ecommerce.repositorios.CategoriaRepositorio;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Este es el Servicio de la clase Categorias.
 * 
 * @version v1.0.0.2
 * @author Pluhator Nicolas
 * 
 */
@Service
public class CategoriaServicio {
    
    @Autowired
    CategoriaRepositorio categoriaRepositorio;
    
    /**
    * Constructor de la CategoriaServicio.
    * 
    * @param categoriaRepositorio Es el repositorio encargado de las operaciones CRUD de Categorias.
    * 
    */
    public CategoriaServicio(CategoriaRepositorio categoriaRepositorio){
        this.categoriaRepositorio = categoriaRepositorio;
    }
    
    /**
    * Nos agregara una nueva categoria.
    * 
    * @param categoria Es la categoria que sera creada.
    * 
    */
    public void agregarCategoria(Categoria categoria){
        categoriaRepositorio.save(categoria);
    }
    
    /**
    * Nos devolvera todas las categorias.
    * 
    * @return Nos devolvera un listado de todas las categorias.
    * 
    */
    public List<Categoria> buscarCategorias(){
        return categoriaRepositorio.findAll();
    }
    
    /**
    * Nos devolvera una categoria buscada por su id.
    * 
    * @param id Es el identificador de la Categoria buscada.
    * @return Categoria Nos retorna una Categoria.
    * 
    */
    public Categoria buscarCategoriaPorId(int id){
        return categoriaRepositorio.findById(id).orElse(null);
    }
    
    /**
    * Nos actualizara una Categoria ya creada.
    * 
    * @param id Es el identificador de la Categoria a editar.
    * @param categoria Los nuevos valores de la categoria.
    * 
    */
    public void actualizarCategoria(int id, Categoria categoria){
        categoriaRepositorio.findById(id).
                ifPresent(categoriaObtenida -> {
                    categoriaObtenida.setNombreCategoria(categoria.getNombreCategoria());
                    categoriaObtenida.setDescripcionCategoria(categoria.getDescripcionCategoria());
                    categoriaObtenida.setUpdated_at(LocalDateTime.now());
                    categoriaRepositorio.save(categoriaObtenida);
                });
    }
    
    /**
    * Nos eliminara una categoria.
    * 
    * @param id Es el identificador de la categoria a eliminar.
    * 
    */
    public void eliminarCategoria(int id){
        Categoria categoria = categoriaRepositorio.findById(id).get();
        categoriaRepositorio.delete(categoria);
    }
}
