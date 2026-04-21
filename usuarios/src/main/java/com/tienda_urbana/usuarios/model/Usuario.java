package com.tienda_urbana.usuarios.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "clave_recuperacion", length = 20)
    private String claveRecuperacion;

    @Column(name = "rol", nullable = false, length = 15)
    @NotBlank(message = "El rol no puede estar en blanco")
    @Size(max = 15, message = "El rol no deberia contener mas de 15 caracteres")
    private String rol;

    @Column(name = "fecha_creacion", nullable = false, length = 10)
    @NotNull(message = "La fecha de creacion de deberia ser nula")
    private LocalDate fechaCreacion;

}
