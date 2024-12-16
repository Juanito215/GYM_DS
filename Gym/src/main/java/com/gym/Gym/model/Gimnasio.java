package com.gym.Gym.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gimnasio")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Gimnasio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto genera un valor autoincrementable para la id
    private Long id_gym;

    @NotBlank
    private String nombre;

    private String direccion;

    private String telefono;

}
