package edu.unam.ecommerce.controladores;

import edu.unam.ecommerce.modelo.Categoria;
import edu.unam.ecommerce.servicios.CategoriaServicio;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Esta clase es de las rutas de Categorias que se van a ofrecer en la pagina.
 * 
 * @version v1.0.0.2
 * @author Pluhator Nicolas
 * 
 */
@Controller
@Slf4j
public class CategoriaController {
    
    @Autowired
    CategoriaServicio categoriaServicio;
    
    /**
    * Es el controlador que inicializa con el servicio.
    * 
    * @param categoriaServicio Es la variable de tipo CategoriaServicio.
    * @see edu.unam.ecommerce.servicios.CategoriaServicio
    * 
    */
    public CategoriaController(CategoriaServicio categoriaServicio){
        this.categoriaServicio = categoriaServicio;
    }
    
    /**
    * Es la funcion que nos llevara a la pagina con un listado de categorias.
    * 
    * @param model Usamos esta variable para mandar los datos de las categorias a la vista.
    * @return El HTML que sera nuestro vista con las categorias.
    * 
    */
    @GetMapping("/categorias")
    public String index(Model model){
        var categorias = categoriaServicio.buscarCategorias();
        model.addAttribute("categorias", categorias);
        return "categoria/index";
    }
    
    /**
    * Es la funcion que nos llevara a la pagina con el formulario para crear una nueva categoria.
    * 
    * @param model Usamos esta variable para mandar el objeto de la nueva Categoria.
    * @return El HTML con el formulario de la Categoria.
    * 
    */
    @GetMapping("/categorias/create")
    public String create(Model model){
        var categoria = new Categoria();
        model.addAttribute("categoria",categoria);
        return "categoria/create";
    }
    
    /**
    * Es la funcion que recibira los datos recibidos del formulario rellenado en create.
    * 
    * @param categoria Usamos esta variable para tomar los valores de la nueva categoria y almacenaarla.
    * @return Nos redirigira a la vista mencionada en index.
    * 
    */
    @PostMapping("/categorias")
    public String store(@Valid Categoria categoria){
        categoriaServicio.agregarCategoria(categoria);
        return "redirect:/categorias";
    }
    
    /**
    * Es la funcion que nos llevara al formulario para actualizar los datos de una Categoria.
    * 
    * @param id Es el identificador de la Categoria.
    * @param model Usamos esta variable para pasar los datos de la Categoria a editar.
    * @return El HTML con el formulario para editar una Categoria.
    * 
    */
    @GetMapping("/categorias/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        var categoria = categoriaServicio.buscarCategoriaPorId(id);
        model.addAttribute("categoria", categoria);
        return "categoria/edit";
    }
    
    /**
    * Es la funcion que recibira los datos recibidos del formulario rellenado en edit.
    * 
    * @param id Es el identificador de la Categoria.
    * @param categoria Usamos esta variable para tomar los valores de la categoria y almacenaarla.
    * @return Nos redirigira a la vista mencionada en index.
    * 
    */
    @PutMapping("/categorias/{id}")
    public String update(@PathVariable int id, @Valid Categoria categoria){
        categoriaServicio.actualizarCategoria(id, categoria);
        return "redirect:/categorias";
    }
    
    /**
    * Es la funcion encargada de dar de baja de una Categoria.
    * 
    * @param id Es el identificador de la Categoria a dar de baja.
    * @return Nos redirige al listado de las Categorias visto en index.
    * 
    */
    @DeleteMapping("/categorias/{id}")
    public String delete(@PathVariable int id){
        categoriaServicio.eliminarCategoria(id);
        return "redirect:/categorias";
    }
}
