package edu.unam.ecommerce.servicios;

import edu.unam.ecommerce.modelo.Producto;
import edu.unam.ecommerce.repositorios.ProductoRepositorio;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Este es el Servicio de la clase Producto.
 * 
 * @version v1.0.0.2
 * @author Pluhator Nicolas
 * 
 */
@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    /**
     * Constructor de la ProductoServicio
     * 
     * @param productoRepositorio Es el repositorio encargado de las operaciones
     *                            CRUD de Productos.
     */
    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    /**
     * Nos agregara un nuevo Producto.
     * 
     * @param producto Es el producto que sera creado.
     * 
     */
    public void agregarProducto(Producto producto) {
        productoRepositorio.save(producto);
    }

    /**
     * Nos devolvera un listado con todos los productos activos.
     * 
     * @return Listado de Productos.
     * 
     */
    public List<Producto> buscarProductos() {
        return productoRepositorio.findAllByEstado(true);
    }

    /**
     * Nos devolvera un Producto.
     * 
     * @param id Es el identificador del Producto buscado.
     * @return Producto Nos devuelve el Producto buscado.
     * 
     */
    public Producto buscarProductoPorId(int id) {
        return productoRepositorio.findById(id).get();
    }

    /**
     * Nos actualizara un Producto.
     * 
     * @param id       Es el identificador del Producto.
     * @param producto Es el producto que sera editado.
     * 
     */
    public void actualizarProductoPorId(int id, Producto producto) {
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

    /**
     * Nos dara de baja un Producto.
     * 
     * @param id Es el producto que sera dado de baja.
     * 
     */
    public void borrarProductoPorId(int id) {
        productoRepositorio.findById(id).ifPresent(productoObtenido -> {
            // productoRepositorio.deleteById(productoObtenido.getIdProducto());
            productoObtenido.setEstado(false);
            productoRepositorio.save(productoObtenido);
        });
    }

    /**
     * Nos devolvera todos los productos que tengan Stock mayor a cero y que a su
     * vez no estan dados de baja.
     * 
     * @return Listado de Productos.
     */
    public List<Producto> obtenerProductosConStockMayorACeroYEstadoActivo() {
        return productoRepositorio.findByStockGreaterThanAndEstadoIsTrue(0);
    }

}
