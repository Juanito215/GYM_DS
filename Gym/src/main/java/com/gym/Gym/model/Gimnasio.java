//package com.gym.Gym.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotBlank;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class Gimnasio {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto genera un valor autoincrementable para la id
//    private Long idGimnasio;
//
//    @NotBlank
//    private String nombre;
//
//    private String direccion;
//
//    private String telefono;
//
//    // falta definir que el gym tiene muchos equipamientos
//
//}
