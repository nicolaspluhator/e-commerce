package edu.unam.ecommerce.servicios;

import edu.unam.ecommerce.modelo.Producto;
import edu.unam.ecommerce.repositorios.ProductoRepositorio;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;
    
    public ProductoServicio(ProductoRepositorio productoRepositorio){
        this.productoRepositorio = productoRepositorio;
    }
    
    public void agregarProducto(Producto producto){ 
        productoRepositorio.save(producto);
    }
    
    public List<Producto> buscarProductos(){
        return productoRepositorio.findAllByEstado(true);
    }
    
    public Producto buscarProductoPorId(int id){
        return productoRepositorio.findById(id).get();
    }
    
    public void actualizarProductoPorId(int id, Producto producto){
        productoRepositorio.findById(id).ifPresent(productoObtenido -> {
            productoObtenido.setNombreProducto(producto.getNombreProducto());
            productoObtenido.setDescripcionProducto(producto.getDescripcionProducto());
            productoObtenido.setMarcaProducto(producto.getMarcaProducto());
            productoObtenido.setCategoria(producto.getCategoria());
            productoObtenido.setStock(producto.getStock());
            productoObtenido.setPrecio(producto.getPrecio());
            productoObtenido.setImagen(producto.getImagen());
            productoObtenido.setUpdated_at(LocalDateTime.now());
            productoRepositorio.save(productoObtenido);
        });
    }
    
    public void borrarProductoPorId(int id){
        productoRepositorio.findById(id).ifPresent(productoObtenido->{
            //productoRepositorio.deleteById(productoObtenido.getIdProducto());
            productoObtenido.setEstado(false);
            productoRepositorio.save(productoObtenido);
        });
    }

}
