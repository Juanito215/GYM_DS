package com.gym.Gym.repository;
import com.gym.Gym.model.Progreso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgresoRepository extends JpaRepository <Progreso, Long> {

    Optional<Progreso> findByNombre(String nombre);

}
