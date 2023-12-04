package edu.unam.ecommerce.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.unam.ecommerce.modelo.Cliente;
import edu.unam.ecommerce.servicios.ClienteServicio;
import jakarta.validation.Valid;

/**
 * Controlador de la clase Cliente.
 */
@Controller
public class ClienteController {

    @Autowired
    ClienteServicio clienteServicio;

    /**
     * Constructor del controlador de cliente.
     * 
     * @param clienteServicio Servicio de la clase cliente.
     */
    public ClienteController(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    /**
     * Pagina principal de clientes.
     * 
     * @param model para mandar los objetos a la vista.
     * @return Vista de Listado de Clientes.
     */
    @GetMapping("/clientes")
    public String index(Model model) {
        var clientes = clienteServicio.listarCliente();
        model.addAttribute("clientes", clientes);
        return "cliente/index";
    }

    /**
     * Pagina de formulario para creacion de cliente.
     * 
     * @param model para mandar objetos a la vista.
     * @return Vista con formulario de cliente.
     */
    @GetMapping("/clientes/create")
    public String create(Model model) {
        var cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "cliente/create";
    }

    /**
     * Ruta para almacenar el cliente.
     * 
     * @param cliente a almacenar
     * @param result  para verificar que no hayan errores.
     * @return index
     */
    @PostMapping("/clientes")
    public String store(@Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "cliente/create";
        }

        clienteServicio.agregarCliente(cliente);
        return "redirect:/clientes";
    }

    /**
     * Vista con formulario para actualizar un cliente.
     * 
     * @param id    identificador del cliente a editar.
     * @param model para mandar objetos a la vista.
     * @return Vista con Formulario de Cliente a editar.
     */
    @GetMapping("/clientes/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        var cliente = clienteServicio.buscarClientePorId(id);
        model.addAttribute("cliente", cliente);
        return "cliente/edit";
    }

    /**
     * Ruta para actualizar al cliente.
     * 
     * @param id      identificador del cliente a editar.
     * @param cliente cliente con los datos actualizados.
     * @param result  para verificar que no hayan errores.
     * @return index
     */
    @PutMapping("/clientes/{id}")
    public String update(@PathVariable int id, @Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "cliente/edit";
        }

        clienteServicio.actualizarClientePorId(id, cliente);
        return "redirect:/clientes";
    }

    /**
     * Ruta para dar de baja un cliente.
     * 
     * @param id identificador del cliente.
     * @return index
     */
    @DeleteMapping("/clientes/{id}")
    public String delete(@PathVariable int id) {
        clienteServicio.bajaCliente(id);
        return "redirect:/clientes";
    }
}
