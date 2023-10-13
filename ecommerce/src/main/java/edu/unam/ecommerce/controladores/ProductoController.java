package edu.unam.ecommerce.controladores;
/*
import edu.unam.ecommerce.modelo.Producto;
import edu.unam.ecommerce.servicios.ProductoServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ProductoController {
    
    @Autowired
    private ProductoServicio productoServicio;
    
    public ProductoController(ProductoServicio productoServicio){
        this.productoServicio = productoServicio;
    }
    
    @GetMapping("/productos")
    public String index(Model model){
        var productos = productoServicio.buscarProductos();
        model.addAttribute("productos", productos);
        return "producto/index";
    }
    
    @GetMapping("/productos/create")
    public String create(Model model){
        var producto = new Producto();
        model.addAttribute("producto", producto);
        return "producto/create";
    }
    
    @PostMapping("/productos")
    public String store(Producto producto){
        productoServicio.agregarProducto(producto);
        return "redirect:/productos";
    }
    
}*/
