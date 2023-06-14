package com.example.demo.Service;

import com.example.demo.Model.Producto;
import com.example.demo.Repository.ProductoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }
    public List<Producto> getProductos(){
        return productoRepository.findAll()
    }
}
