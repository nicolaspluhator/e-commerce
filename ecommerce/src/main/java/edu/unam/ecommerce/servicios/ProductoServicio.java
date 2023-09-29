package edu.unam.ecommerce.servicios;

import edu.unam.ecommerce.modelo.Producto;
import edu.unam.ecommerce.repositorios.ProductoRepositorio;
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
        return productoRepositorio.findAll();
    }
    
    public Producto buscarProductoPorId(int id){
        return productoRepositorio.findById(id).get();
    }
    
    public void actualizarProductoPorId(int id, Producto producto){
        productoRepositorio.findById(id).ifPresent(productoObtenido -> {
            productoObtenido.setNombreProd(producto.getNombreProd());
            productoObtenido.setDescProd(producto.getDescProd());
            productoObtenido.setCategProd(producto.getCategProd());
            productoObtenido.setPrecioProd(producto.getPrecioProd());
            productoObtenido.setCantProd(producto.getCantProd());
            productoRepositorio.save(productoObtenido);
        });
    }
    
    public void borrarProductoPorId(int id){
        productoRepositorio.findById(id).ifPresent(productoObtenido->{
            productoRepositorio.deleteById(productoObtenido.getIdProd());
        });
    }
}
