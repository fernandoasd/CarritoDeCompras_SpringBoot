package com.example.demo.Repository;

import com.example.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository
        extends JpaRepository <Category, Long>{

    @Query("SELECT s FROM Category s WHERE s.nombre = ?1") //JPQL
    Optional<Category> findCategoriaByName(String nombre);
}
