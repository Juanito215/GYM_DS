package com.gym.Gym.repository;

import com.gym.Gym.model.Rutinas;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface RutinasRepository extends JpaRepository<Rutinas, Long> {

    Optional<Rutinas> findByNombre(String nombre);

}
