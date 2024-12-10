//package com.gym.Gym.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Set;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Ejercicios {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String nombre;
//
//    private String descripcion;
//
//    private String zonaCuerpo;
//
//    @ManyToMany
//    @JoinTable(
//        name = "equipamiento_ejercicios", // Nombre de la tabla intermedia
//        joinColumns = @JoinColumn(name = "ejercicio_id"),
//        inverseJoinColumns = @JoinColumn(name = "equipamiento_id")
//    )
//    private Set<Equipamiento> equipamientos; // Relación ManyToMany con Equipamiento
//
//}
