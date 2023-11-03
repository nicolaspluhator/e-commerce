package edu.unam.ecommerce.controladores;

import edu.unam.ecommerce.modelo.Producto;
import edu.unam.ecommerce.servicios.CategoriaServicio;
import edu.unam.ecommerce.servicios.ProductoServicio;
import jakarta.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Esta clase es de las rutas de Productos que se van a ofrecer en la pagina.
 * 
 * @version v1.0.0.2
 * @author Pluhator Nicolas
 * 
 */
@Controller
@Slf4j
public class ProductoController {
    public Path directorioImagenes = Paths.get("src//main//resources//static//images");
    public String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
    // public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "//"
    // + "uploads";
    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private CategoriaServicio categoriaServicio;

    /**
     * Es el controlador que inicializa con el servicio.
     * 
     * @param productoServicio Es la variable de tipo ProductoServicio.
     * @see edu.unam.ecommerce.servicios.ProductoServicio
     * 
     */
    public ProductoController(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    /**
     * Es la funcion que nos llevara a la pagina con un listado de productos.
     * 
     * @param model Usamos esta variable para mandar los datos de los productos a la
     *              vista.
     * @return El HTML que sera nuestro vista con los productos.
     * 
     */
    @GetMapping("/productos")
    public String index(Model model) {
        var productos = productoServicio.buscarProductos();
        model.addAttribute("productos", productos);
        return "producto/index";
    }

    /**
     * Es la funcion que nos llevara a la pagina para la creacion de un nuevo
     * producto.
     * 
     * @param model Usamos esta variable para mandar el objeto Producto a rellenar a
     *              la vista.
     * @return El HTML que sera nuestro vista con el formulario para un nuevo
     *         Producto.
     * 
     */
    @GetMapping("/productos/create")
    public String create(Model model) {
        var producto = new Producto();
        var categorias = categoriaServicio.buscarCategorias();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        return "producto/create";
    }

    /**
     * Es la funcion que nos almacenara nuestro nuevo producto.
     * 
     * @param producto Es el nuevo producto a guardar.
     * @param imagen   Es la imagen del producto que vamos a guardar.
     * @throws IOException Es por si sucede algun error en la carga de la imagen del
     *                     producto.
     * @return Nos redirigira al listado de productos visto en index.
     * 
     */
    @PostMapping("/productos")
    public String store(@Valid @ModelAttribute Producto producto, @RequestParam("file") MultipartFile imagen)
            throws IOException {

        if (!imagen.isEmpty()) {
            String uniqueFilename = UUID.randomUUID().toString() + "_" + imagen.getOriginalFilename();
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(rutaAbsoluta, uniqueFilename);
            // Path fileNameAndPath = Paths.get(rutaAbsoluta, imagen.getOriginalFilename());
            // fileNames.append(imagen.getOriginalFilename());
            fileNames.append(uniqueFilename);
            Files.write(fileNameAndPath, imagen.getBytes());
            String nombre = fileNames.toString();
            producto.setImagen(nombre);
        }
        productoServicio.agregarProducto(producto);
        return "redirect:/productos";
    }

    /**
     * Es la funcion que nos llevara a la pagina para ver los detalles de un
     * Producto.
     * 
     * @param model Usamos esta variable para mandar el objeto Producto a la vista y
     *              ver sus datos.
     * @param id    Es el id del producto a ver los detalles.
     * @return El HTML que sera nuestra vista para ver los detalles de un Producto.
     * 
     */
    @GetMapping("/productos/{id}/show")
    public String show(Model model, @PathVariable int id) {
        var producto = productoServicio.buscarProductoPorId(id);
        model.addAttribute("producto", producto);
        return "producto/show";
    }

    /**
     * Es la funcion que nos llevara a la pagina para la edicion de un producto
     * existente.
     * 
     * @param model Usamos esta variable para mandar el objeto Producto a
     *              actualizar.
     * @param id    Es el identificador del producto a actualizar.
     * @return El HTML que sera nuestro vista con el formulario para actualizar el
     *         Producto.
     * 
     */
    @GetMapping("/productos/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        var producto = productoServicio.buscarProductoPorId(id);
        var categorias = categoriaServicio.buscarCategorias();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        return "producto/edit";
    }

    /**
     * Es la funcion que actualizara nuestro Producto.
     * 
     * @param id       Es el identificador del producto a actualizar.
     * @param producto Es el producto con los datos a actualizar.
     * @param imagen   Es la imagen del producto a actualizar.
     * @throws IOException Es para manejar los errores que puedan ocurrir al subir
     *                     una imagen.
     * @return Nos redirige al listado de los productos visto en index.
     * 
     */
    @PutMapping("/productos/{id}")
    public String update(@PathVariable int id, @Valid @ModelAttribute Producto producto,
            @RequestParam("file") MultipartFile imagen) throws IOException {

        if (!imagen.isEmpty()) {
            String uniqueFilename = UUID.randomUUID().toString() + "_" + imagen.getOriginalFilename();
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(rutaAbsoluta, uniqueFilename);
            // Path fileNameAndPath = Paths.get(rutaAbsoluta, imagen.getOriginalFilename());
            // fileNames.append(imagen.getOriginalFilename());
            fileNames.append(uniqueFilename);
            Files.write(fileNameAndPath, imagen.getBytes());
            String nombre = fileNames.toString();
            producto.setImagen(nombre);
        }

        productoServicio.actualizarProductoPorId(id, producto);
        return "redirect:/productos";
    }

    /**
     * Es la funcion encargada de dar de baja de un Producto.
     * 
     * @param id Es el identificador del Producto a dar de baja.
     * @return Nos redirige al listado de los productos visto en index.
     * 
     */
    @DeleteMapping("/productos/{id}")
    public String delete(@PathVariable int id) {
        productoServicio.borrarProductoPorId(id);
        return "redirect:/productos";
    }

}
