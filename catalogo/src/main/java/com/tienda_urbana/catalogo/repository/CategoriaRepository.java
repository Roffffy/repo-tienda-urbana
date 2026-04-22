package com.tienda_urbana.catalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienda_urbana.catalogo.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT * FROM CATEGORIA WHERE nombre LIKE CONCAT('%',:query,'%')", nativeQuery = true)
    public List<Categoria> obtenerPorNombreParecido(@Param("query") String query);
}
