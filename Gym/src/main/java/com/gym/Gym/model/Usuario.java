package com.gym.Gym.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto genera un valor autoincrementable para la id
    private Long id;

    @NotBlank
    private String nombre;
    @NotBlank
    private String objetivo;
    private double peso;

    private double altura;

    private double porcentaje_Grasa ;

    private String tipo_anatomia;

    private String genero;

    private String nivel_entrenamiento;

    private int edad;

    private String alimentacion;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasena;
}