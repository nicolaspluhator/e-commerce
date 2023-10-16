package edu.unam.ecommerce.controladores;

import edu.unam.ecommerce.modelo.Producto;
import edu.unam.ecommerce.servicios.CategoriaServicio;
import edu.unam.ecommerce.servicios.ProductoServicio;
import edu.unam.ecommerce.servicios.UploadFileService;
import jakarta.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
public class ProductoController {
    public Path directorioImagenes = Paths.get("src//main//resources//static//images");
    public String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
    //public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "//" + "uploads";
    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private CategoriaServicio categoriaServicio;
    
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
        var categorias = categoriaServicio.buscarCategorias();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        return "producto/create";
    }
    
    @PostMapping("/productos")
    public String store(@Valid @ModelAttribute Producto producto, @RequestParam("file") MultipartFile imagen) throws IOException{
        
        if(!imagen.isEmpty()){
            String uniqueFilename = UUID.randomUUID().toString() + "_" + imagen.getOriginalFilename();
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(rutaAbsoluta, uniqueFilename);
            //Path fileNameAndPath = Paths.get(rutaAbsoluta, imagen.getOriginalFilename());
            //fileNames.append(imagen.getOriginalFilename());
            fileNames.append(uniqueFilename);
            Files.write(fileNameAndPath, imagen.getBytes());
            String nombre = fileNames.toString();
            producto.setImagen(nombre);
        }
        productoServicio.agregarProducto(producto);
        return "redirect:/productos";
    }
    
    @GetMapping("/productos/{id}/show")
    public String show(Model model, @PathVariable int id){
        var producto = productoServicio.buscarProductoPorId(id);
        model.addAttribute("producto", producto);
        return "producto/show";
    }
    
    @GetMapping("/productos/{id}/edit")
    public String edit(Model model, @PathVariable int id){
        var producto = productoServicio.buscarProductoPorId(id);
        var categorias = categoriaServicio.buscarCategorias();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        return "producto/edit";
    }
    
    @PutMapping("/productos/{id}")
    public String update(@PathVariable int id, @Valid @ModelAttribute Producto producto, @RequestParam("file") MultipartFile imagen) throws IOException{
        
        if(!imagen.isEmpty()){
            String uniqueFilename = UUID.randomUUID().toString() + "_" + imagen.getOriginalFilename();
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(rutaAbsoluta, uniqueFilename);
            //Path fileNameAndPath = Paths.get(rutaAbsoluta, imagen.getOriginalFilename());
            //fileNames.append(imagen.getOriginalFilename());
            fileNames.append(uniqueFilename);
            Files.write(fileNameAndPath, imagen.getBytes());
            String nombre = fileNames.toString();
            producto.setImagen(nombre);
        }
        
        productoServicio.actualizarProductoPorId(id, producto);
        return "redirect:/productos";
    }
    
    @DeleteMapping("/productos/{id}")
    public String delete(@PathVariable int id){
        productoServicio.borrarProductoPorId(id);
        return "redirect:/productos";
    }
    
}
