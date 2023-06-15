package com.example.demo.Service;

import com.example.demo.Model.Category;
import com.example.demo.Repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Category> getCategorias(){
        return categoriaRepository.findAll();
    }
    public void addNewCategoria(Category category) {
        //BUSINESS LOGIC

        //Ctrl+Alt+V = Extract/Introduce
        Optional<Category> categoriaByName = categoriaRepository.
                findCategoriaByName(category.getNombre());
        //si ya existe el nombre del producto envia una excepcion
        //en application.properties usar server.error.include-message=always
        //para mostrar el mensaje
        if (categoriaByName.isPresent()){
            throw new IllegalStateException("categoria name taken");
        }
        categoriaRepository.save(category);
    }


    public void deleteCategoria(Long categoriaId) {
        Optional<Category> exists = categoriaRepository.findById(categoriaId);
        if (!exists.isPresent()){
            throw new IllegalStateException(
                    "product with id " + categoriaId + " does not exists");
        }
        categoriaRepository.deleteById(categoriaId);
    }

    //    Transsactional sirve para no implementar JPQL
    @Transactional
    public void updateCategoria(Long categoriaId, String nombre) {
        Category category = categoriaRepository.findById(categoriaId).orElseThrow(() -> new IllegalStateException(
                "categoria with id " + categoriaId + " does not exists"));

        if (nombre != null &&
                nombre.length() > 0 &&
                !Objects.equals(category.getNombre(), nombre)){
            Optional<Category> categoriaByName = categoriaRepository.
                    findCategoriaByName(nombre);
            if (categoriaByName.isPresent()){
                throw new IllegalStateException("categoria exists");
            }
            category.setNombre(nombre);
        }
    }
}


