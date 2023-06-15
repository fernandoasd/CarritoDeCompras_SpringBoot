package com.example.demo.Repository;

import com.example.demo.Model.CarritoCompras;
import com.example.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarritoComprasRepository
        extends JpaRepository<CarritoCompras, Long> {
    @Query("SELECT s FROM CarritoCompras s WHERE s.id = ?1") //JPQL
    Optional<CarritoCompras> findCarritoComprasById(Long id);
}
