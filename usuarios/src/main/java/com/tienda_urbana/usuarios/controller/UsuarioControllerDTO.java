package com.tienda_urbana.usuarios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda_urbana.usuarios.dto.UsuarioRequestDto;
import com.tienda_urbana.usuarios.dto.UsuarioResponseDTO;
import com.tienda_urbana.usuarios.service.UsuarioServiceDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioControllerDTO {

    private final UsuarioServiceDTO usuarioServiceDTO;
    
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> visualizarDatos(@PathVariable Long id){
        return ResponseEntity.ok(usuarioServiceDTO.visualizarUsuario(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@Valid @RequestBody UsuarioRequestDto dto) {
        return ResponseEntity.status(201).body(usuarioServiceDTO.crearUsuario(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> actualizarDatos(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDto dto){
        return ResponseEntity.status(201).body(usuarioServiceDTO.actualizarDatos(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        usuarioServiceDTO.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
