package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(schema = "ProductosCrud")
public class Product {
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
    @Column
    private String categoria;
    @Column
    private String subCategoria;
    @Column
    private String descripcion;
    @Column
    private double precio;
    @Column
    private String foto;
    @Column
    private int tamanio;
    @Column
    private String tipo;
//    @Transient sirve para que no se guarde en la BBDD

    public Product(Long id) {
        this.id = id;
    }

    public Product(Long id, String nombre, String categoria, String subCategoria, String descripcion, double precio, int tamanio, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tamanio = tamanio;
        this.tipo = tipo;
    }

    public Product(String nombre, String categoria, String subCategoria, String descripcion, double precio, int tamanio, String tipo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tamanio = tamanio;
        this.tipo = tipo;
    }

    public Product(String nombre, String categoria, String subCategoria, String descripcion, double precio, String foto, int tamanio, String tipo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.tamanio = tamanio;
        this.tipo = tipo;
    }

    public Product() {

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
    public String getFoto() {
        return foto;
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

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", subCategoria='" + subCategoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", foto='" + foto + '\'' +
                ", tamanio=" + tamanio +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}