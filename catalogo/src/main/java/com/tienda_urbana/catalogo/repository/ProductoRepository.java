package com.tienda_urbana.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda_urbana.catalogo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
