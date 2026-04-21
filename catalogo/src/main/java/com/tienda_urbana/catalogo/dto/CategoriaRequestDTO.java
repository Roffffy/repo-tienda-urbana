package com.tienda_urbana.catalogo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequestDTO {

    @NotBlank(message = "El nombre de la categoria no puede estar en blanco")
    @Size(max = 20, message = "El nombre no puede contener mas de 20 caracteres")
    private String nombre;
}
