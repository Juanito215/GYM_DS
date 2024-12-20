package com.gym.Gym.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipamiento_ejercicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamientoEjercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipamiento_id", referencedColumnName = "id", nullable = false)
    private Equipamiento equipamiento; // Relación con la tabla Equipamiento

    @ManyToOne
    @JoinColumn(name = "ejercicio_id", referencedColumnName = "id", nullable = false)
    private Ejercicios ejercicio; // Relación con la tabla Ejercicios

    private String descripcion;

    // Campos temporales para recibir los IDs desde el JSON
    @Transient
    private Long equipamientoId;

    @Transient
    private Long ejercicioId;
}
