package com.gym.Gym.repository;

import com.gym.Gym.model.UsuariosRutinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRutinasRepository extends JpaRepository<UsuariosRutinas, Long> {

}
