package edu.unam.ecommerce.controladores;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.unam.ecommerce.modelo.Estado;
import edu.unam.ecommerce.modelo.Tipo;
import edu.unam.ecommerce.modelo.Transaccion;
import edu.unam.ecommerce.servicios.TransaccionProductoServicio;
import edu.unam.ecommerce.servicios.TransaccionServicio;
import jakarta.validation.Valid;

/**
 * Este es el controlador de la clase de Ventas.
 * 
 * @author Pluhator Nicolas
 * @version 1.0.0.5
 */
@Controller
public class VentasController {
    @Autowired
    TransaccionServicio ventaServicio;

    @Autowired
    TransaccionProductoServicio detalleVentaServicio;

    /**
     * Constructor de la clase VentaController.
     * 
     * @param ventaServicio Servicio de la venta.
     */
    public VentasController(TransaccionServicio ventaServicio) {
        this.ventaServicio = ventaServicio;
    }

    /**
     * Ruta principal de Ventas.
     * 
     * @param model de la vista.
     * @return Vista de Listado de todas las ventas.
     */
    @GetMapping("/ventas")
    public String index(Model model) {
        var ventas = ventaServicio.listarVentas();
        model.addAttribute("ventas", ventas);
        return "venta/index";
    }

    /**
     * Ruta para crear una Venta.
     * 
     * @param model de la vista.
     * @return Vista de Formulario para crear Venta.
     */
    @GetMapping("/ventas/create")
    public String create(Model model) {
        var venta = new Transaccion();
        model.addAttribute("venta", venta);
        return "venta/create";
    }

    /**
     * Ruta para almacenar la venta.
     * 
     * @param transaccion Venta a guardar
     * @return Redirije al listado principal.
     */
    @PostMapping("/ventas")
    public String store(@Valid Transaccion transaccion) {
        Date fecha = transaccion.getFecha();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        transaccion.setFecha(calendar.getTime());
        transaccion.setEstado(Estado.INICIADA);
        transaccion.setTipo(Tipo.VENTA);
        ventaServicio.agregarTransaccion(transaccion);
        return "redirect:/ventas";
    }

    /**
     * Ruta para ver una venta
     * 
     * @param model model de la vista.
     * @param id    Identificador de la Venta.
     * @return Vista de la Venta.
     */
    @GetMapping("/ventas/{id}/show")
    public String show(Model model, @PathVariable int id) {
        var venta = ventaServicio.buscarTransaccionPorId(id);
        var renglones = venta.getRenglones();
        model.addAttribute("venta", venta);
        model.addAttribute("renglones", renglones);
        return "venta/show";
    }

    /**
     * Ruta para editar una venta en particular.
     * 
     * @param model model de la vista
     * @param id    Identificador de la Venta.
     * @return Vista de Editar Venta.
     */
    @GetMapping("/ventas/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        var venta = ventaServicio.buscarTransaccionPorId(id);
        model.addAttribute("venta", venta);
        return "venta/edit";
    }

    /**
     * Ruta para actualizar la venta.
     * 
     * @param venta que sera actualizada.
     * @param id    identificador de la venta.
     * @return Redirije al listado de Ventas.
     */
    @PutMapping("/ventas/{id}")
    public String update(@Valid Transaccion venta, @PathVariable int id) {
        Date fecha = venta.getFecha();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        venta.setFecha(calendar.getTime());
        ventaServicio.actualizarTransaccion(id, venta);
        return "redirect:/ventas";
    }

    /**
     * Ruta para dar de baja una venta.
     * 
     * @param id identificador de la venta a dar de Baja.
     * @return Redirije al listado de ventas.
     */
    @DeleteMapping("/ventas/{id}")
    public String delete(@PathVariable int id) {
        ventaServicio.eliminarTransaccion(id);
        return "redirect:/ventas";
    }

    /**
     * Ruta para finalizar una Transaccion.
     * 
     * @param id de la Transaccion.
     */
    @GetMapping("/ventas/{id}/complete")
    public String complete(@PathVariable int id) {
        var venta = ventaServicio.buscarTransaccionPorId(id);
        ventaServicio.finalizarTransaccion(venta);
        return "redirect:/ventas";
    }
}
