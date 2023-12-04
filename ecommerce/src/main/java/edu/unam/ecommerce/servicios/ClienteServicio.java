package edu.unam.ecommerce.servicios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unam.ecommerce.modelo.Cliente;
import edu.unam.ecommerce.repositorios.ClienteRepositorio;

/**
 * Servicios de la clase Cliente.
 * 
 * @version 1.0.0.7
 * @author Pluhator Nicolas
 */
@Service
public class ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    /**
     * Constructor de clase de Servicio.
     * 
     * @param clienteRepositorio Repositorio de la clase Cliente.
     */
    public ClienteServicio(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    /**
     * Retornara un listado de los clientes activos.
     * 
     * @return Listado de clientes activos.
     */
    public List<Cliente> listarCliente() {
        return clienteRepositorio.findAllByEstado(false);
    }

    /**
     * Busqueda de un cliente por su identificador.
     * 
     * @param id identificador del cliente.
     * @return Cliente buscado
     */
    public Cliente buscarClientePorId(int id) {
        return clienteRepositorio.findById(id).get();
    }

    /**
     * Guarda un cliente en la BD.
     * 
     * @param cliente a almacenar.
     */
    public void agregarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    /**
     * Actualiza un cliente.
     * 
     * @param id      identificador del cliente a ser actualizado.
     * @param cliente con los valores a actualizar.
     */
    public void actualizarClientePorId(int id, Cliente cliente) {
        clienteRepositorio.findById(id).ifPresent(clienteObtenido -> {
            clienteObtenido.setNombreCliente(cliente.getNombre());
            clienteObtenido.setApellidoCliente(cliente.getApellidoCliente());
            clienteObtenido.setDniCliente(cliente.getDniCliente());
            clienteObtenido.setEmailCliente(cliente.getEmailCliente());
            clienteObtenido.setDireccionCliente(cliente.getDireccionCliente());
            clienteObtenido.setTransaccionesCliente(cliente.getTransacciones());
            clienteObtenido.setEstado(cliente.getEstado());
            clienteObtenido.setUpdated_at(LocalDateTime.now());
            clienteRepositorio.save(clienteObtenido);
        });
    }

    /**
     * Si el cliente tiene asociado transacciones el sistema le cambiara su estado a
     * true, que representara la baja logica del cliente
     * en cambio si el cliente no tiene asociado transacciones se lo borrara del
     * sistema.
     * 
     * @param id identificador del cliente a dar de baja.
     */
    public void bajaCliente(int id) {
        var cliente = clienteRepositorio.findById(id).get();
        if (cliente.getTransacciones().isEmpty()) {
            clienteRepositorio.delete(cliente);
        } else {
            cliente.setEstado(true);
            this.actualizarClientePorId(id, cliente);
        }
    }
}
