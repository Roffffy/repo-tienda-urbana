package com.tienda_urbana.catalogo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tienda_urbana.catalogo.dto.CategoriaRequestDTO;
import com.tienda_urbana.catalogo.dto.CategoriaResponseDTO;
import com.tienda_urbana.catalogo.service.CategoriaServiceDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CatalogoControllerDTO {


    private final CategoriaServiceDTO categoriaServiceDTO;

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> mostrarTodasCategorias(){
        return ResponseEntity.ok(categoriaServiceDTO.mostrarTodasCategorias());
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoriaResponseDTO>> obtenerPorNombreParecido(@RequestParam String query){
        return ResponseEntity.ok(categoriaServiceDTO.obtenerPorNombreParecido(query));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> agregarCategoria(@Valid @RequestBody CategoriaRequestDTO dto){
        return ResponseEntity.status(201).body(categoriaServiceDTO.agregarCategoria(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> modificarCategoria(@PathVariable Long id, @Valid @RequestBody CategoriaRequestDTO dto) {
        return ResponseEntity.ok(categoriaServiceDTO.modificarCategoria(id, dto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id){
        categoriaServiceDTO.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
