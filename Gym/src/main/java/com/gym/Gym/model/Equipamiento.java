    package com.gym.Gym.model;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.ManyToMany;
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
        @ManyToMany
        @JoinColumn(name = "id_gimnasio", nullable = false) // Define la clave foránea

        private Set<Gimnasio> gimnasio;
    }
