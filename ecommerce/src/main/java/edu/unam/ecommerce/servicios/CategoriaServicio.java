package edu.unam.ecommerce.servicios;

import edu.unam.ecommerce.modelo.Categoria;
import edu.unam.ecommerce.repositorios.CategoriaRepositorio;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServicio {
    
    @Autowired
    CategoriaRepositorio categoriaRepositorio;
    
    public CategoriaServicio(CategoriaRepositorio categoriaRepositorio){
        this.categoriaRepositorio = categoriaRepositorio;
    }
    
    public void agregarCategoria(Categoria categoria){
        categoriaRepositorio.save(categoria);
    }
    
    public List<Categoria> buscarCategorias(){
        return categoriaRepositorio.findAll();
    }
    
    public Categoria buscarCategoriaPorId(int id){
        return categoriaRepositorio.findById(id).orElse(null);
    }
    
    public void actualizarCategoria(int id, Categoria categoria){
        categoriaRepositorio.findById(id).
                ifPresent(categoriaObtenida -> {
                    categoriaObtenida.setNombreCategoria(categoria.getNombreCategoria());
                    categoriaObtenida.setDescripcionCategoria(categoria.getDescripcionCategoria());
                    categoriaObtenida.setUpdated_at(LocalDateTime.now());
                    categoriaRepositorio.save(categoriaObtenida);
                });
    }
    
    public void eliminarCategoria(int id){
        Categoria categoria = categoriaRepositorio.findById(id).get();
        categoriaRepositorio.delete(categoria);
    }
}
