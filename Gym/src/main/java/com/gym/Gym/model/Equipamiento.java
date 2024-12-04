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

    public class Equipamiento {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto genera un valor autoincrementable para la id
        private Long idEquipamiento;

        @NotBlank
        private String nombre;

        @NotBlank
        private String objetivo;

        private String descripcion;

        // Relación ManyToOne con Gimnasio
        @OneToMany(mappedBy = "Gimnasio") // Define la relación inversa
        @JoinColumn(name = "id_gimnasio", nullable = false) // Define la clave foránea

        private Set<Gimnasio> gimnasio;

    }
