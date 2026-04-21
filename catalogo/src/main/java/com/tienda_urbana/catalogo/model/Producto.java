package com.tienda_urbana.catalogo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private int precio;

    @Column(name = "talla", nullable = false, length = 10)
    private String talla;

    @Column(name = "foto_url")
    private String fotoUrl;

    @Column(name = "stock", nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
