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

import edu.unam.ecommerce.modelo.Proveedor;
import edu.unam.ecommerce.servicios.ProveedorServicio;
import jakarta.validation.Valid;

/**
 * Controlador de la clase Proveedor.
 */
@Controller
public class ProveedorController {

    @Autowired
    ProveedorServicio proveedorServicio;

    /**
     * Constructor de ProveedorController.
     * 
     * @param proveedorServicio Servicio de Proveedor.
     */
    public ProveedorController(ProveedorServicio proveedorServicio) {
        this.proveedorServicio = proveedorServicio;
    }

    /**
     * Pagina principal de Proveedores.
     * 
     * @return Vista con listado de todos los Proveedores.
     */
    @GetMapping("/proveedores")
    public String index(Model model) {
        var proveedores = proveedorServicio.listarProveedor();
        model.addAttribute("proveedores", proveedores);
        return "proveedor/index";
    }

    /**
     * Pagina con Formulario para la creacion de un Proveedor.
     * 
     * @param model para mandar los objetos a la vista.
     * @return Vista con Formulario para Proveedor.
     */
    @GetMapping("/proveedores/create")
    public String create(Model model) {
        var proveedor = new Proveedor();
        model.addAttribute("proveedor", proveedor);
        return "proveedor/create";
    }

    /**
     * Ruta para almacenar un Proveedor.
     * 
     * @param proveedor a guardar en la BD.
     * @param result    para validar los datos recibidos.
     * @return index
     */
    @PostMapping("/proveedores")
    public String store(@Valid Proveedor proveedor, BindingResult result) {
        if (result.hasErrors()) {
            return "proveedor/create";
        }

        proveedorServicio.agregarProveedor(proveedor);
        return "redirect:/proveedores";
    }

    /**
     * Vista de Formulario para editar un Proveedor.
     * 
     * @param id    identificador del proveedor a actualizar.
     * @param model para mandar objetos a la vista.
     * @return Vista con formulario para actualizar.
     */
    @GetMapping("proveedores/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        var proveedor = proveedorServicio.buscarProveedorPorId(id);
        model.addAttribute("proveedor", proveedor);
        return "proveedor/edit";
    }

    /**
     * Ruta para actualizar un proveedor.
     * 
     * @param id        identificador del proveedor a actualizar.
     * @param proveedor con los datos actualizados.
     * @param result    para validar los datos recibidos.
     * @return index
     */
    @PutMapping("proveedores/{id}")
    public String update(@PathVariable int id, @Valid Proveedor proveedor, BindingResult result) {
        if (result.hasErrors()) {
            return "proveedor/edit";
        }

        proveedorServicio.actualizarProveedorPorId(id, proveedor);
        return "redirect:/proveedores";
    }

    /**
     * Ruta para dar de baja un proveedor.
     * 
     * @param id identificador del proveedor.
     * @return index
     */
    @DeleteMapping("/proveedores/{id}")
    public String delete(@PathVariable int id) {
        proveedorServicio.bajaProveedor(id);
        return "redirect:/proveedores";
    }
}
