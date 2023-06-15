package com.example.demo.Controller;

import com.example.demo.Model.CarritoCompras;
import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Service.CarritoComprasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/carritocompras")
public class CarritoComprasController {
    private final CarritoComprasService carritoComprasService;

    public CarritoComprasController(CarritoComprasService carritoComprasService) {
        this.carritoComprasService = carritoComprasService;
    }
    @GetMapping(value = "/carrito")
    public List<CarritoCompras> getCarritoCompras(){
        return carritoComprasService.getCarritoCompras();
    }

    @PostMapping
    public void registerNewCarritoCompras(@RequestBody CarritoCompras carritoCompras){
        carritoComprasService.addNewCarritoCompras(carritoCompras);
    }

    @DeleteMapping(path = "{carritoComprasId}")
    public void deleCarritoCompras(@PathVariable("carritoComprasId") Long carritoComprasId){
        carritoComprasService.deleCarritoCompras(carritoComprasId);
    }
}
