package edu.unam.ecommerce.servicios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unam.ecommerce.modelo.Estado;
import edu.unam.ecommerce.modelo.Tipo;
import edu.unam.ecommerce.modelo.Transaccion;
import edu.unam.ecommerce.modelo.TransaccionProducto;
import edu.unam.ecommerce.repositorios.TransaccionRepositorio;

/**
 * Servicios de la clase Transaccion.
 * 
 * @version v1.0.0.4
 * @author Pluhator Nicolas
 */
@Service
public class TransaccionServicio {

    @Autowired
    TransaccionRepositorio transaccionRepositorio;

    @Autowired
    ProductoServicio productoServicio;

    /**
     * Constructor de TransaccionServicio.
     * 
     * @param transaccionRepositorio
     */
    public TransaccionServicio(TransaccionRepositorio transaccionRepositorio) {
        this.transaccionRepositorio = transaccionRepositorio;
    }

    /**
     * Agrega una nueva transaccion.
     * 
     * @param transaccion
     */
    public void agregarTransaccion(Transaccion transaccion) {
        transaccionRepositorio.save(transaccion);
    }

    /**
     * Devuelve una lista de todas las transacciones.
     * 
     * @return List de transacciones.
     */
    public List<Transaccion> listarTransaccion() {
        return transaccionRepositorio.findAll();
    }

    /**
     * Devuelve una Transaccion que coincida con el id pasado por parametro.
     * 
     * @param id
     * @return Transaccion buscada
     */
    public Transaccion buscarTransaccionPorId(int id) {
        return transaccionRepositorio.findById(id).get();
    }

    /**
     * Actualiza una transaccion.
     * 
     * @param id
     * @param transaccion
     */
    public void actualizarTransaccion(int id, Transaccion transaccion) {
        transaccionRepositorio.findById(id).ifPresent(transaccionObtenida -> {
            transaccionObtenida.setNroFactura(transaccion.getNroFactura());
            transaccionObtenida.setFecha(transaccion.getFecha());
            transaccionObtenida.setUpdated_at(LocalDateTime.now());
            transaccionObtenida.setRenglones(transaccion.getRenglones());
            transaccionRepositorio.save(transaccionObtenida);
        });
    }

    /**
     * Elimina una transaccion si esta no tiene renglones asociados. Caso contratio
     * lo colocará en estado "CANCELADA".
     * 
     * @param id
     */
    public void eliminarTransaccion(int id) {
        Transaccion transaccion = transaccionRepositorio.findById(id).get();
        if (transaccion.getRenglones().isEmpty()) {
            transaccionRepositorio.delete(transaccion);
        } else {
            transaccion.setEstado(Estado.CANCELADA);
            this.actualizarTransaccion(id, transaccion);
        }
    }

    /**
     * Cambia el estado de la Transaccion a FINALIZADA y actualiza el stock de los
     * productos.
     * 
     * @param transaccion
     */
    public void finalizarTransaccion(Transaccion transaccion) {
        int cantidad = 0;
        if (transaccion.getTipo() == Tipo.COMPRA) {

            for (TransaccionProducto renglon : transaccion.getRenglones()) {
                var producto = productoServicio.buscarProductoPorId(renglon.getProducto().getIdProducto());
                cantidad = producto.getStock() + renglon.getCantidad();
                producto.setStock(cantidad);
                productoServicio.actualizarProductoPorId(producto.getIdProducto(), producto);
                cantidad = 0;
            }
            transaccion.setEstado(Estado.FINALIZADA);
            this.actualizarTransaccion(transaccion.getIdTransaccion(), transaccion);
        }
    }
}
