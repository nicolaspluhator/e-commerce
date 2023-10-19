package edu.unam.ecommerce.controladores;

import edu.unam.ecommerce.servicios.ProductoServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Esta clase de las rutas de la vista principal de la pagina.
 * 
 * @version v1.0.0.2
 * @author Pluhator Nicolas
 * 
 */
@Controller
@Slf4j
public class HomeController {
    
    @Autowired
    ProductoServicio productoServicio;
    /**
    * index Es la funcion que nos llevara a la pagina con un listado de productos.
    * @param model Usamos esta variable para mandar los datos de los productos a la vista.
    * @return El HTML que sera nuestro vista principal con los productos.
    */
    @GetMapping("/")
    public String index(Model model){
        var productos = productoServicio.buscarProductos();
        model.addAttribute("productos", productos);
        return "index";
    }
}
