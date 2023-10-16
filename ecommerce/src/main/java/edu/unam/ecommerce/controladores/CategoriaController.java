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

@Controller
@Slf4j
public class CategoriaController {
    
    @Autowired
    CategoriaServicio categoriaServicio;
    
    public CategoriaController(CategoriaServicio categoriaServicio){
        this.categoriaServicio = categoriaServicio;
    }
    
    @GetMapping("/categorias")
    public String index(Model model){
        var categorias = categoriaServicio.buscarCategorias();
        model.addAttribute("categorias", categorias);
        return "categoria/index";
    }
    
    @GetMapping("/categorias/create")
    public String create(Model model){
        var categoria = new Categoria();
        model.addAttribute("categoria",categoria);
        return "categoria/create";
    }
    
    @PostMapping("/categorias")
    public String store(@Valid Categoria categoria){
        categoriaServicio.agregarCategoria(categoria);
        return "redirect:/categorias";
    }
    
    @GetMapping("/categorias/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        var categoria = categoriaServicio.buscarCategoriaPorId(id);
        model.addAttribute("categoria", categoria);
        return "categoria/edit";
    }
    
    @PutMapping("/categorias/{id}")
    public String update(@PathVariable int id, @Valid Categoria categoria){
        categoriaServicio.actualizarCategoria(id, categoria);
        return "redirect:/categorias";
    }
    
    @DeleteMapping("/categorias/{id}")
    public String delete(@PathVariable int id){
        categoriaServicio.eliminarCategoria(id);
        return "redirect:/categorias";
    }
}
