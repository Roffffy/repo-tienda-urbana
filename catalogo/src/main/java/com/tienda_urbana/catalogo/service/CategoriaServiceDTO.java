package com.tienda_urbana.catalogo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tienda_urbana.catalogo.dto.CategoriaRequestDTO;
import com.tienda_urbana.catalogo.dto.CategoriaResponseDTO;
import com.tienda_urbana.catalogo.model.Categoria;
import com.tienda_urbana.catalogo.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceDTO {

    private final CategoriaRepository categoriaRepository;

    public CategoriaResponseDTO mapToDto(Categoria categoria) {
        return new CategoriaResponseDTO(categoria.getNombre());
    }

    public List<CategoriaResponseDTO> mostrarTodasCategorias() {
        return categoriaRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public CategoriaResponseDTO agregarCategoria(CategoriaRequestDTO dto) {
        Categoria categoria = new Categoria(null, dto.getNombre());
        return mapToDto(categoriaRepository.save(categoria));
    }

    public CategoriaResponseDTO modificarCategoria(Long id, CategoriaRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La categoria no se encontro"));
        categoria.setNombre(dto.getNombre());
        return mapToDto(categoriaRepository.save(categoria));
    }

    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
