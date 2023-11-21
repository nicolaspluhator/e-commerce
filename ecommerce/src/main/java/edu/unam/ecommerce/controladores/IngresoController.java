package edu.unam.ecommerce.controladores;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.unam.ecommerce.modelo.Estado;
import edu.unam.ecommerce.modelo.Tipo;
import edu.unam.ecommerce.modelo.Transaccion;
import edu.unam.ecommerce.servicios.TransaccionProductoServicio;
import edu.unam.ecommerce.servicios.TransaccionServicio;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Controlador para manejar los ingresos.
 * 
 * @version v1.0.0.4
 * @author Pluhator Nicolas
 * 
 */
@Controller
public class IngresoController {
    @Autowired
    TransaccionServicio transaccionServicio;

    @Autowired
    TransaccionProductoServicio renglon;

    /**
     * Constructor del Controlador de Ingresos
     * 
     * @param transaccionServicio Servicio de Transaccion.
     */
    public IngresoController(TransaccionServicio transaccionServicio) {
        this.transaccionServicio = transaccionServicio;
    }

    /**
     * Ruta principal de los ingresos.
     * 
     * @param model model de la vista.
     * @return Vista con Listado de los Ingresos.
     */
    @GetMapping("/ingresos")
    public String index(Model model) {
        var ingresos = transaccionServicio.listarIngresos();
        model.addAttribute("ingresos", ingresos);
        return "ingreso/index";
    }

    /**
     * Ruta para crear un nuevo Ingreso.
     * 
     * @param model model de la vista.
     * @return Vista con formulario para crear un Ingreso.
     */
    @GetMapping("/ingresos/create")
    public String create(Model model) {
        var ingreso = new Transaccion();
        model.addAttribute("ingreso", ingreso);
        return "ingreso/create";
    }

    /**
     * Ruta para almacenar el nuevo Ingreso.
     * 
     * @param transaccion ingreso a almacenar.
     * @return Redirije al listado principal.
     */
    @PostMapping("/ingresos")
    public String store(@Valid Transaccion transaccion) {
        Date fecha = transaccion.getFecha();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        transaccion.setFecha(calendar.getTime());
        transaccion.setEstado(Estado.INICIADA);
        transaccion.setTipo(Tipo.COMPRA);
        transaccionServicio.agregarTransaccion(transaccion);
        return "redirect:/ingresos";
    }

    /**
     * Ruta para mostrar en detalle una Transaccion.
     * 
     * @param model model de la vista.
     * @param id    de la Transaccion.
     * @return Vista al show.
     */
    @GetMapping("/ingresos/{id}/show")
    public String show(Model model, @PathVariable int id) {
        var ingreso = transaccionServicio.buscarTransaccionPorId(id);
        var renglones = ingreso.getRenglones();
        model.addAttribute("ingreso", ingreso);
        model.addAttribute("renglones", renglones);
        return "ingreso/show";
    }

    /**
     * Ruta para finalizar una Transaccion.
     * 
     * @param id de la Transaccion.
     */
    @GetMapping("/ingresos/{id}/complete")
    public String complete(@PathVariable int id) {
        var ingreso = transaccionServicio.buscarTransaccionPorId(id);
        transaccionServicio.finalizarTransaccion(ingreso);
        return "redirect:/ingresos";
    }

    /**
     * Ruta para editar una Transaccion.
     * 
     * @param model model de la vista.
     * @param id    identificador del ingreso a editar
     * @return Vista de edit.
     */
    @GetMapping("/ingresos/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        var ingreso = transaccionServicio.buscarTransaccionPorId(id);
        model.addAttribute("ingreso", ingreso);
        return "ingreso/edit";
    }

    /**
     * Ruta para actualizar una Transaccion.
     * 
     * @param ingreso ingreso a editar.
     * @param id      identificador del ingreso a editar.
     * @return Redirije al listado de Transacciones.
     */
    @PutMapping("/ingresos/{id}")
    public String update(@Valid Transaccion ingreso, @PathVariable int id) {
        Date fecha = ingreso.getFecha();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        ingreso.setFecha(calendar.getTime());
        transaccionServicio.actualizarTransaccion(id, ingreso);
        return "redirect:/ingresos";
    }

    /**
     * Ruta para eliminar una Transaccion.
     * 
     * @param id identificador del ingreso a dar de baja.
     * @return Redirije al listado de Transacciones.
     */
    @DeleteMapping("/ingresos/{id}")
    public String delete(@PathVariable int id) {
        transaccionServicio.eliminarTransaccion(id);
        return "redirect:/ingresos";
    }
}
