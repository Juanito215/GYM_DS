package com.gym.Gym.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "progreso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Progreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario; // Relación con la tabla Usuario

    private Double peso;

    private Double porcentaje_grasa;

    private String comentarios;

    // Campo temporal para recibir el ID del usuario desde el JSON
    @Transient
    private Long usuarioId;
}
