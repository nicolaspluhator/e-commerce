package edu.unam.ecommerce.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unam.ecommerce.modelo.Estado;
import edu.unam.ecommerce.modelo.TransaccionProducto;
import edu.unam.ecommerce.repositorios.TransaccionProductoRepositorio;

/**
 * Servicios de la clase TransaccionProducto (Renglones).
 * 
 * @version v1.0.0.4
 * @author Pluhator Nicolas
 */
@Service
public class TransaccionProductoServicio {

    @Autowired
    TransaccionProductoRepositorio transaccionProductoRepositorio;

    /**
     * Constructor de TrasaccionProductoServicio.
     * 
     * @param transaccionProductoRepositorio
     */
    public TransaccionProductoServicio(TransaccionProductoRepositorio transaccionProductoRepositorio) {
        this.transaccionProductoRepositorio = transaccionProductoRepositorio;
    }

    /**
     * Agrega un nuevo renglon a una Transaccion.
     * 
     * @param transaccionProducto renglon a agregar.
     */
    public void agregarRenglon(TransaccionProducto transaccionProducto) {
        transaccionProducto.getTransaccion().getRenglones().add(transaccionProducto);
        transaccionProducto.getTransaccion().setEstado(Estado.PENDIENTE);
        transaccionProductoRepositorio.save(transaccionProducto);
    }

    /**
     * Retorna una lista de todos los renglones pertenecientes a una Transaccion.
     * 
     * @return Lista de TransaccionProducto.
     */
    public List<TransaccionProducto> listarRenglones() {
        return transaccionProductoRepositorio.findAll();
    }

    /**
     * Retorna un renglon buscado por su identificador.
     * 
     * @param id identificador del renglon a buscar
     * @return TransaccionProducto renglon.
     */
    public TransaccionProducto buscarRenglonPorId(int id) {
        return transaccionProductoRepositorio.findById(id).get();
    }

    /**
     * Actualiza los valores de un renglon.
     * 
     * @param id                  identificador del renglon a editar.
     * @param transaccionProducto renglon a actualizar.
     */
    public void actualizarRenglon(int id, TransaccionProducto transaccionProducto) {
        transaccionProductoRepositorio.findById(id).ifPresent(transaccionProductoObtenido -> {
            transaccionProductoObtenido.setCantidad(transaccionProducto.getCantidad());
            transaccionProductoObtenido.setPrecioUnidad(transaccionProducto.getPrecioUnidad());
            transaccionProductoObtenido.setProducto(transaccionProducto.getProducto());
            transaccionProductoObtenido.setTransaccion(transaccionProducto.getTransaccion());
            transaccionProductoRepositorio.save(transaccionProductoObtenido);
        });
    }

    /**
     * Elimina un renglon.
     * 
     * @param id identificador del renglon.
     */
    public void eliminarRenglon(int id) {
        TransaccionProducto renglon = transaccionProductoRepositorio.findById(id).get();
        transaccionProductoRepositorio.delete(renglon);
    }
}
