package com.example.demo.Service;

import com.example.demo.Model.CarritoCompras;
import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Repository.CarritoComprasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoComprasService {
    private final CarritoComprasRepository carritoComprasRepository;

    public CarritoComprasService(CarritoComprasRepository carritoComprasRepository) {
        this.carritoComprasRepository = carritoComprasRepository;
    }
    public List<CarritoCompras> getCarritoCompras(){
        return carritoComprasRepository.findAll();
    }

    public void deleCarritoCompras(Long carritoComprasId) {
        Optional<CarritoCompras> exists = carritoComprasRepository.findById(carritoComprasId);
        if (!exists.isPresent()){
            throw new IllegalStateException(
                    "carritoCompras with id " + carritoComprasId + " does not exists");
        }
        carritoComprasRepository.deleteById(carritoComprasId);
    }

    public void addNewCarritoCompras(CarritoCompras carritoCompras) {
        Optional<CarritoCompras> carritoById = carritoComprasRepository.
                findCarritoComprasById(carritoCompras.getId());
    }
}
