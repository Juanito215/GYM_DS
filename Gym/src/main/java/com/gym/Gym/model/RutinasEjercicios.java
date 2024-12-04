package com.gym.Gym.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Rutinas_Ejercicios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RutinasEjercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long rutinas_id;

    private long ejercicios_id;

    private int repeticiones;

    private int series;
}
