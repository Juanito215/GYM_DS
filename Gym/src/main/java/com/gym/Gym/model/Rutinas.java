package com.gym.Gym.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rutinas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Rutinas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto genera un valor autoincrementable para la id
    private Long id;

    @NotBlank
    private String nombre;

    private String objetivo;

    private String descripcion;

    private String nivel_entrenamiento;
}


