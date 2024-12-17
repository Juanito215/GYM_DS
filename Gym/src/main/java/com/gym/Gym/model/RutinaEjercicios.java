package com.gym.Gym.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rutina_ejercicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RutinaEjercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rutina_id", referencedColumnName = "id", nullable = false)
    private Rutinas rutina; // Relación con la tabla Rutinas

    @ManyToOne
    @JoinColumn(name = "ejercicio_id", referencedColumnName = "id", nullable = false)
    private Ejercicios ejercicio; // Relación con la tabla Ejercicios

    private int repeticiones;

    private int series;

    // Campos temporales para recibir IDs desde el JSON
    @Transient
    private Long rutinaId;

    @Transient
    private Long ejercicioId;
}
