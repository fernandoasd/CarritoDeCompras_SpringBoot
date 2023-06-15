package com.example.demo.Config;

import com.example.demo.Model.CarritoCompras;
import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Repository.CarritoComprasRepository;
import com.example.demo.Repository.CategoriaRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Productconfig {
    @Bean
    CommandLineRunner commandLineRunner(
            CategoriaRepository categoriaRepository,
            ProductRepository productoRepository,
            UsuarioRepository usuarioRepository,
            CarritoComprasRepository carritoComprasRepository){
        return args -> {
            Category legumbres = new Category(
                    "legumbre");

            Category frutas = new Category(
                    "fruta");

            Category verduras = new Category(
                    "verdura");

            categoriaRepository.saveAll(
                    List.of(verduras, legumbres, frutas)
            );

            Product banana = new Product(
                    "banana",
                    frutas,
                    "fruta",
                    "fruta x 10 unidades",
                    550,
                    "",
                    2000,
                    "perecedero"
            );
            Product lentejas = new Product(
                    "lentejas",
                    legumbres,
                    "legumbres",
                    "legumbres enlatadas en salmuera",
                    260,
                    "",
                    450,
                    "perecedero"
            );
            Product lechuga = new Product(
                    "lechuga",
                    verduras,
                    "lechuga",
                    "lechuga manteca",
                    300,
                    "",
                    500,
                    "perecedero"
            );

            productoRepository.saveAll(
                    List.of(banana, lechuga, lentejas)
            );

            User user1 =new User(
                    "usuario1@gmail.com",
                    "password1"
            );

            User user2 =new User(
                    "usuario2@gmail.com",
                    "password2"
            );

            usuarioRepository.saveAll(List.of(user1, user2)
            );

            CarritoCompras carrito1 = new CarritoCompras(1L, 2, lechuga, user2);

            carritoComprasRepository.saveAll(List.of(carrito1));
        };
    }
}
