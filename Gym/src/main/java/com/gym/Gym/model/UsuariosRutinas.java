package com.gym.Gym.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Usuarios_Rutinas")
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosRutinas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long usuarios_id;

    private long rutinas_id;

    private String fecha_asignada;

    private String progreso;

}
