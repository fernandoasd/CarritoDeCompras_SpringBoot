package com.example.demo.Config;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Productconfig {
    @Bean
    CommandLineRunner commandLineRunner(
            ProductRepository repository){
        return args -> {
            Product banana = new Product(
                    "banana",
                    "fruta",
                    "fruta",
                    "fruta x 10 unidades",
                    550,
                    "",
                    2000,
                    "perecedero"
            );
            Product lentejas = new Product(
                    "lentejas",
                    "legumbres",
                    "legumbres",
                    "legumbres enlatadas en salmuera",
                    260,
                    "",
                    450,
                    "perecedero"
            );
            Product choclo = new Product(
                    "choclo",
                    "grano",
                    "cereal",
                    "legumbres",
                    300,
                    "",
                    500,
                    "perecedero"
            );

            repository.saveAll(
                    List.of(banana, choclo, lentejas)
            );
        };
    }
}
