package com.gym.Gym.repository;

import com.gym.Gym.model.Ejercicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicios, Long> {
    Optional<Ejercicios> findByNombre(String nombre);;
}
