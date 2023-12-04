package edu.unam.ecommerce.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.unam.ecommerce.modelo.TransaccionProducto;
import edu.unam.ecommerce.servicios.ProductoServicio;
import edu.unam.ecommerce.servicios.TransaccionProductoServicio;
import edu.unam.ecommerce.servicios.TransaccionServicio;
import jakarta.validation.Valid;

/**
 * Este es el controlador de los Detalles de Ventas.
 * 
 * @author Pluhator Nicolas
 * @version 1.0.0.5
 */
@Controller
public class DetalleVentaController {

    @Autowired
    TransaccionProductoServicio detalleVentaServicio;

    @Autowired
    TransaccionServicio ventaServicio;

    @Autowired
    ProductoServicio productoServicio;

    /**
     * Constructor de DetalleVentaController
     * 
     * @param detalleVentaServicio Servicio de TransaccionProducto.
     * @param ventaServicio        Servicio de Venta.
     */
    public DetalleVentaController(TransaccionProductoServicio detalleVentaServicio, TransaccionServicio ventaServicio) {
        this.detalleVentaServicio = detalleVentaServicio;
        this.ventaServicio = ventaServicio;
    }

    /**
     * Ruta para agregar un renglon.
     * 
     * @param id    de la venta.
     * @param model model de la vista
     * @return Vista para agregar un renglon
     */
    @GetMapping("/ventas/{id}/add")
    public String create(@PathVariable int id, Model model) {
        var venta = ventaServicio.buscarTransaccionPorId(id);
        var productos = productoServicio.obtenerProductosConStockMayorACeroYEstadoActivo();
        var detalleVenta = new TransaccionProducto();
        model.addAttribute("venta", venta);
        model.addAttribute("productos", productos);
        model.addAttribute("detalleVenta", detalleVenta);
        return "detalle_venta/create";
    }

    /**
     * Ruta para almacenar un renglon.
     * 
     * @param renglon de la venta
     * @return Redirije al show de la venta.
     */
    @PostMapping("/ventas/add")
    public String store(@Valid TransaccionProducto renglon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            var productos = productoServicio.obtenerProductosConStockMayorACeroYEstadoActivo();
            model.addAttribute("venta", renglon.getTransaccion());
            model.addAttribute("productos", productos);
            model.addAttribute("detalleVenta", renglon);
            return "detalle_venta/create";
        }
        var precio = renglon.getProducto().getPrecio();
        renglon.setPrecioUnidad(precio);
        detalleVentaServicio.agregarRenglon(renglon);
        return "redirect:/ventas/" + renglon.getTransaccion().getIdTransaccion() + "/show";
    }

    /**
     * Ruta para editar un renglon.
     * 
     * @param model         model de la vista
     * @param idTransaccion Es el identificador de la venta
     * @param idRenglon     identificador del renglon
     * @return Vista edit.
     */
    @GetMapping("/ventas/{idTransaccion}/edit/{idRenglon}")
    public String edit(Model model, @PathVariable int idTransaccion, @PathVariable int idRenglon) {
        var renglon = detalleVentaServicio.buscarRenglonPorId(idRenglon);
        var productos = productoServicio.obtenerProductosConStockMayorACeroYEstadoActivo();
        model.addAttribute("renglon", renglon);
        model.addAttribute("productos", productos);
        return "detalle_venta/edit";
    }

    /**
     * Ruta para actualizar un renglon.
     * 
     * @param idTransaccion identificador de la Venta.
     * @param idRenglon     identificador del renglon.
     * @param renglon       renglon a editar.
     * @return Vista show de Transaccion.
     */
    @PutMapping("/ventas/{idTransaccion}/update/{idRenglon}")
    public String update(@PathVariable int idTransaccion,
            @PathVariable int idRenglon, @Valid @ModelAttribute TransaccionProducto renglon) {
        var precio = renglon.getProducto().getPrecio();
        renglon.setPrecioUnidad(precio);
        detalleVentaServicio.actualizarRenglon(idRenglon, renglon);
        return "redirect:/ventas/" + renglon.getTransaccion().getIdTransaccion() + "/show";
    }

    /**
     * Ruta para quitar un renglon.
     * 
     * @param idTransaccion identificador de la venta.
     * @param idRenglon     identificador del renglon
     * @return Vista show de Transaccion.
     */
    @DeleteMapping("/ventas/{idTransaccion}/revome/{idRenglon}")
    public String delete(@PathVariable int idTransaccion,
            @PathVariable int idRenglon) {
        detalleVentaServicio.eliminarRenglon(idRenglon);

        return "redirect:/ventas/" + idTransaccion + "/show";
    }

}
