package com.tienda_urbana.usuarios.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.tienda_urbana.usuarios.dto.UsuarioRequestDto;
import com.tienda_urbana.usuarios.dto.UsuarioResponseDTO;
import com.tienda_urbana.usuarios.model.Usuario;
import com.tienda_urbana.usuarios.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceDTO {

    private final UsuarioRepository usuarioRepository;

    private UsuarioResponseDTO mapToDto(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getNombre(), usuario.getEmail(), usuario.getClaveRecuperacion(),
                usuario.getFechaCreacion());
    }

    public UsuarioResponseDTO crearUsuario(UsuarioRequestDto dto) {
        Usuario usuario = new Usuario(null, dto.getNombre(), dto.getEmail(), dto.getPassword(), null, "Cliente",
                LocalDate.now());
        return mapToDto(usuarioRepository.save(usuario));
    }

    public UsuarioResponseDTO actualizarDatos(Long id, UsuarioRequestDto dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        return mapToDto(usuarioRepository.save(usuario));
    }
    
    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
