package com.gym.Gym.repository;

import com.gym.Gym.model.Ejercicios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EjercicioRepository extends JpaRepository<Ejercicios, Long> {
    Optional<Ejercicios> findByNombre(String nombre);
}