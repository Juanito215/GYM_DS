package com.gym.Gym.repository;

import com.gym.Gym.model.Gimnasio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Long> {

    Optional<Gimnasio> findByNombre(String nombre);
}
