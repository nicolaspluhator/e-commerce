package edu.unam.ecommerce.servicios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unam.ecommerce.modelo.Proveedor;
import edu.unam.ecommerce.repositorios.ProveedorRepositorio;

/**
 * Servicio del modelo Proveedor
 * 
 * @version 1.0.0.7
 * @author Pluhator Nicolas
 */
@Service
public class ProveedorServicio {

    @Autowired
    ProveedorRepositorio proveedorRepositorio;

    /**
     * Constructor del ProveedorServicio
     * 
     * @param proveedorRepositorio
     */
    public ProveedorServicio(ProveedorRepositorio proveedorRepositorio) {
        this.proveedorRepositorio = proveedorRepositorio;
    }

    /**
     * Retorna un proveedor por el identificador buscado
     * 
     * @param id identificador del proveedor
     * @return Proveedor buscado
     */
    public Proveedor buscarProveedorPorId(int id) {
        return proveedorRepositorio.findById(id).get();
    }

    /**
     * Listara todos los proveedores activos.
     * 
     * @return Lista de proveedores
     */
    public List<Proveedor> listarProveedor() {
        return proveedorRepositorio.findAllByEstado(false);
    }

    /**
     * Agregara un proveedor a la BD.
     * 
     * @param proveedor que se agregara.
     */
    public void agregarProveedor(Proveedor proveedor) {
        proveedorRepositorio.save(proveedor);
    }

    /**
     * Actualizara el proveedor.
     * 
     * @param id        identificador del proveedor a actualizar.
     * @param proveedor con los datos actualizados.
     */
    public void actualizarProveedorPorId(int id, Proveedor proveedor) {
        proveedorRepositorio.findById(id).ifPresent(proveedorObtenido -> {
            proveedorObtenido.setNombreProveedor(proveedor.getNombre());
            proveedorObtenido.setTelefonoProveedor(proveedor.getTelefono());
            proveedorObtenido.setEstado(proveedor.getEstado());
            proveedorObtenido.setDescripcionProveedor(proveedor.getDescripcionProveedor());
            proveedorObtenido.setTransaccionesProveedor(proveedor.getTransacciones());
            proveedorObtenido.setUpdated_at(LocalDateTime.now());
            proveedorRepositorio.save(proveedorObtenido);
        });
    }

    /**
     * Si el proveedor tiene transacciones asociadas este solo se le dara una baja
     * logica. En caso contrario se borrara el Proveedor
     * 
     * @param id identificador del proveedor
     */
    public void bajaProveedor(int id) {
        var proveedor = proveedorRepositorio.findById(id).get();
        if (proveedor.getTransacciones().isEmpty()) {
            proveedorRepositorio.delete(proveedor);
        } else {
            proveedor.setEstado(true);
            this.actualizarProveedorPorId(id, proveedor);
        }
    }
}
