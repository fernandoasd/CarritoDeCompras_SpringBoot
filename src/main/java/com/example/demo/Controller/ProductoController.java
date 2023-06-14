package com.example.demo.Controller;

import com.example.demo.Model.Producto;
import com.example.demo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping(value = "/productos")
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }

    @PostMapping(value = "/guardarproducto")
    public String guardarProducto(@RequestBody Producto producto){
        productoService.sa
    }
}
