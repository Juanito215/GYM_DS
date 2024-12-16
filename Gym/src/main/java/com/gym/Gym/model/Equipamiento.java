package com.gym.Gym.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipamiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del equipamiento no puede estar vacío.")
    private String nombre;

    private String descripcion;

    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "gimnasio_id", nullable = false) // Relación con gimnasio
    private Gimnasio gimnasio;

    @Transient
    private Long gimnasioId;
}
