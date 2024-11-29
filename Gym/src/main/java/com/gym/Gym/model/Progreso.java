package com.gym.Gym.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Progreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto genera un valor autoincrementable para la id
    private Long idProgreso;

    @NotBlank
    private String fecha;

    private double peso;

    private double porcentajeGrasa;

    private String comentarios;

    // Relación ManyToOne con Gimnasio
    @ManyToMany
    @JoinColumn(name = "id_Progreso", nullable = false) // Define la clave foránea

    private Set<Progreso> progresos;


}
