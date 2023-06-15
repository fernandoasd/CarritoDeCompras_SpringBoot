package com.example.demo.Controller;

import com.example.demo.Model.Category;
import com.example.demo.Service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = "/categorias")
    public List<Category> getCategoria(){
        return categoriaService.getCategorias();
    }

    @PostMapping
    public void registrarNuevaCategoria(@RequestBody Category category){
        categoriaService.addNewCategoria(category);
    }

    @DeleteMapping(path = "{categoriaId}")
    public void deleteCategoria(@PathVariable("categoriaId") Long categoriaId){
        categoriaService.deleteCategoria(categoriaId);
    }

    @PutMapping(path = "{categoriaId}")
    public void updateCategoria(@PathVariable("categoriaId") Long categoriaId,
                                @RequestParam(required = false) String nombre){
        categoriaService.updateCategoria(categoriaId,
                nombre);
    }
}
