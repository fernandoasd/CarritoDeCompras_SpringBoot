package com.example.demo.Model;

import jakarta.persistence.*;

@Entity

@Table(name = "carrito_compras")
public class CarritoCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUsuario() {
        return user;
    }

    public void setUsuario(User user) {
        this.user = user;
    }

    public CarritoCompras(Long id, int cantidad, Product product, User user) {
        this.id = id;
        this.cantidad = cantidad;
        this.product = product;
        this.user = user;
    }

    public CarritoCompras() {
    }

    public CarritoCompras(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CarritoCompras{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", product=" + product +
                ", usuario=" + user +
                '}';
    }
}
