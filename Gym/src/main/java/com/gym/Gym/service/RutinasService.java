package com.gym.Gym.service;

import com.gym.Gym.model.Rutinas;
import com.gym.Gym.repository.RutinasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutinasService {

    @Autowired
    private RutinasRepository rutinasRepository;

    public Rutinas registrarRutinas(Rutinas rutinas) {
        return rutinasRepository.save(rutinas);
    }

}
