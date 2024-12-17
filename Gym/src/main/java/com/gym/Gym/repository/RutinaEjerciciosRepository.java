package com.gym.Gym.repository;

import com.gym.Gym.model.RutinaEjercicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RutinaEjerciciosRepository extends JpaRepository<RutinaEjercicios, Long> {
}
