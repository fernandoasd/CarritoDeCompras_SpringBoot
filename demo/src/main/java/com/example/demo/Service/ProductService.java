package com.example.demo.Service;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> getProductos(){
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        //BUSINESS LOGIC

        //Ctrl+Alt+V = Extract/Introduce
        Optional<Product> productByName = productRepository.
                findProductByName(product.getNombre());
        //si ya existe el nombre del producto envia una excepcion
        //en application.properties usar server.error.include-message=always
        //para mostrar el mensaje
        if (productByName.isPresent()){
            throw new IllegalStateException("product name taken");
        }
        productRepository.save(product);
    }


    public void deleteProduct(Long productId) {
        Optional<Product> exists = productRepository.findById(productId);
        if (!exists.isPresent()){
            throw new IllegalStateException(
                    "product with id " + productId + " does not exists");
        }
        productRepository.deleteById(productId);
    }

//    Transsactional sirve para no implementar JPQL
    @Transactional
    public void updateProduct(Long productId, String nombre, Category category, String subCategoria, String descripcion, String precio, String foto, String tamanio, String tipo) {
    Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException(
            "product with id " + productId + " does not exists"));

        if (nombre != null &&
                nombre.length() > 0 &&
                !Objects.equals(product.getNombre(), nombre)){
            Optional<Product> productByName = productRepository.
                    findProductByName(nombre);
            if (productByName.isPresent()){
                throw new IllegalStateException("product exists");
            }
            product.setNombre(nombre);
        }

        if (category != null &&
                !Objects.equals(product.getCategoria(), category)){
            product.setCategoria(category);
        }

        if (subCategoria != null &&
                subCategoria.length() > 0 &&
                !Objects.equals(product.getSubCategoria(), subCategoria)){
            product.setSubCategoria(subCategoria);
        }

        if (descripcion != null &&
                descripcion.length() > 0 &&
                !Objects.equals(product.getDescripcion(), descripcion)){
            product.setDescripcion(descripcion);
        }

        if (precio != null &&
                precio.length() > 0){
            product.setPrecio(Double.parseDouble(precio));
        }

        if (foto != null &&
                foto.length() > 0 &&
                !Objects.equals(product.getFoto(), foto)){
            product.setFoto(foto);
        }
        if (tamanio != null &&
                tamanio.length() > 0){
            product.setTamanio(Integer.parseInt(tamanio));
        }

        if (tipo != null &&
                tipo.length() > 0 &&
                !Objects.equals(product.getTipo(), tipo)){
            product.setTipo(tipo);
        }
    }
}
