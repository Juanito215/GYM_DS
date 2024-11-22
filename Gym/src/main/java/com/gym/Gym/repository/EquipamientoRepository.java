package com.gym.Gym.repository;

import com.gym.Gym.model.Equipamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipamientoRepository extends JpaRepository<Equipamiento, Long> {

    Optional<Equipamiento> findByNombre(String nombre);
}
