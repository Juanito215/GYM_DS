package com.gym.Gym.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario_rutinas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosRutinas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "rutina_id", referencedColumnName = "id", nullable = false)
    private Rutinas rutina;

    private LocalDateTime fechaAsignacion;

    private String progreso;

    // Campos temporales para manejar IDs en las relaciones
    @Transient
    private Long usuarioId;

    @Transient
    private Long rutinaId;
}
