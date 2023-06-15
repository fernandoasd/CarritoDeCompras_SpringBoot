package com.example.demo.Repository;

import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository
        extends JpaRepository<User, Long> {
    @Query("SELECT s FROM User s WHERE s.email = ?1") //JPQL
    Optional<User> findUserByEmail(String email);
}
