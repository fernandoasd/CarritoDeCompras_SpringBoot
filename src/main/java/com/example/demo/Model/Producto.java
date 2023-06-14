package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(schema = "ProductosCrud")
public class Producto {
    @Id
//    @SequenceGenerator(
//            name = "producto_sequence",
//            sequenceName = "producto_sequence",
//            allocationSize = 1
//    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    private String categoria;
    private String subCategoria;
    private String descripcion;
    private double precio;
    private int tamanio;
    private String tipo;

    public Producto(Long id) {
        this.id = id;
    }

    public Producto(Long id, String nombre, String categoria, String subCategoria, String descripcion, double precio, int tamanio, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tamanio = tamanio;
        this.tipo = tipo;
    }

    public Producto(String nombre, String categoria, String subCategoria, String descripcion, double precio, int tamanio, String tipo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tamanio = tamanio;
        this.tipo = tipo;
    }

    public Producto() {

    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getTamanio() {
        return tamanio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", subCategoria='" + subCategoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", tamanio=" + tamanio +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}