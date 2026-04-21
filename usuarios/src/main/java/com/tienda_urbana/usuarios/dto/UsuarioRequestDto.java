package com.tienda_urbana.usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDto {

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(max = 50, message = "El nombre no puede contener mas de 50 caracteres")
    private String nombre;

    @Email(message = "Correo invalido")
    @NotBlank(message = "El correo no puede estar vacio")
    @Size(max = 50, message = "El correo no puede contener mas de 50 caracteres")
    private String email;

    @NotBlank(message = "La contraseña no puede quedar en blanco")
    @Size(min = 8, max = 20, message = "La contraseña debe contener entre 8 y 20 caracteres")
    private String password;

}
