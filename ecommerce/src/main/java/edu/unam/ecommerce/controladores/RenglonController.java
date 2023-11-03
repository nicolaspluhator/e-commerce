package edu.unam.ecommerce.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.unam.ecommerce.modelo.TransaccionProducto;
import edu.unam.ecommerce.repositorios.TransaccionProductoRepositorio;
import edu.unam.ecommerce.servicios.ProductoServicio;
import edu.unam.ecommerce.servicios.TransaccionProductoServicio;
import edu.unam.ecommerce.servicios.TransaccionServicio;
import jakarta.validation.Valid;

/**
 * Controlador para manejar los renglones.
 * 
 * @version v1.0.0.4
 * @author Pluhator Nicolas
 * 
 */
@Controller
public class RenglonController {
    @Autowired
    TransaccionProductoRepositorio transaccionProductoRepositorio;

    @Autowired
    TransaccionServicio transaccionServicio;

    @Autowired
    TransaccionProductoServicio transaccionProductoServicio;

    @Autowired
    ProductoServicio productoServicio;

    /**
     * Ruta para agregar un renglon.
     * 
     * @param model
     * @param idTransaccion
     * @return Vista create.
     */
    @GetMapping("/ingresos/{idTransaccion}/add")
    public String create(Model model, @PathVariable int idTransaccion) {
        var ingreso = transaccionServicio.buscarTransaccionPorId(idTransaccion);
        var renglon = new TransaccionProducto();
        var productos = productoServicio.buscarProductos();
        model.addAttribute("ingreso", ingreso);
        model.addAttribute("renglon", renglon);
        model.addAttribute("productos", productos);
        return "renglon/create";
    }

    /**
     * Ruta para almacenar un renglon.
     * 
     * @param renglon.
     * @return Vista show de Transaccion.
     */
    @PostMapping("/ingresos/add")
    public String store(@Valid TransaccionProducto renglon) {
        transaccionProductoServicio.agregarRenglon(renglon);
        return "redirect:/ingresos/" + renglon.getTransaccion().getIdTransaccion() + "/show";
    }

    /**
     * Ruta para editar un renglon.
     * 
     * @param model
     * @param idTransaccion
     * @param idRenglon
     * @return Vista edit.
     */
    @GetMapping("/ingresos/{idTransaccion}/edit/{idRenglon}")
    public String edit(Model model, @PathVariable int idTransaccion, @PathVariable int idRenglon) {
        var renglon = transaccionProductoServicio.buscarRenglonPorId(idRenglon);
        var productos = productoServicio.buscarProductos();
        model.addAttribute("renglon", renglon);
        model.addAttribute("productos", productos);
        return "renglon/edit";
    }

    /**
     * Ruta para actualizar un renglon.
     * 
     * @param idTransaccion
     * @param idRenglon
     * @param renglon
     * @return Vista show de Transaccion.
     */
    @PutMapping("/ingresos/{idTransaccion}/update/{idRenglon}")
    public String update(@PathVariable int idTransaccion,
            @PathVariable int idRenglon, @Valid @ModelAttribute TransaccionProducto renglon) {
        transaccionProductoServicio.actualizarRenglon(idRenglon, renglon);
        return "redirect:/ingresos/" + renglon.getTransaccion().getIdTransaccion() + "/show";
    }

    /**
     * Ruta para quitar un renglon.
     * 
     * @param idTransaccion
     * @param idRenglon
     * @return Vista show de Transaccion.
     */
    @DeleteMapping("/ingresos/{idTransaccion}/revome/{idRenglon}")
    public String delete(@PathVariable int idTransaccion,
            @PathVariable int idRenglon) {
        transaccionProductoServicio.eliminarRenglon(idRenglon);
        return "redirect:/ingresos/" + idTransaccion + "/show";
    }
}
