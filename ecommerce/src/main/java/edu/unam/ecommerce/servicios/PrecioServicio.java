package edu.unam.ecommerce.servicios;

import edu.unam.ecommerce.modelo.Precio;
import edu.unam.ecommerce.repositorios.PrecioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrecioServicio {
    
    @Autowired
    PrecioRepositorio precioRepositorio;
    
    public PrecioServicio(PrecioRepositorio precioRepositorio){
        this.precioRepositorio = precioRepositorio;
    }
    
    public void agregarPrecio(Precio precio){
        precio.getProducto().getPrecios().add(precio);
        precioRepositorio.save(precio);
    }
    
    public List<Precio> buscarPrecios(){
        return precioRepositorio.findAll();
    }
    
    public Precio buscarPrecioPorId(int id){
        return precioRepositorio.findById(id).get();
    }

}
