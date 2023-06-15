package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/productos")
    public List<Product> getProductos(){
        return productService.getProductos();
    }

//    @PostMapping(value = "/guardarproducto")
//    public String guardarProducto(@RequestBody Producto producto){
//        productoService.sa
//    }
    @PostMapping
    public void registrarNuevoProducto(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long studentId){
        productService.deleteProduct(studentId);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(@PathVariable("productId") Long productId,
                              @RequestParam(required = false) String nombre,
                              @RequestParam(required = false) String categoria,
                              @RequestParam(required = false) String subCategoria,
                              @RequestParam(required = false) String descripcion,
                              @RequestParam(required = false) String precio,
                              @RequestParam(required = false) String foto,
                              @RequestParam(required = false) String tamanio,
                              @RequestParam(required = false) String tipo){
        productService.updateProduct(productId,
                nombre,
                categoria,
                subCategoria,
                descripcion,
                precio,
                foto,
                tamanio,
                tipo);



    }
}
