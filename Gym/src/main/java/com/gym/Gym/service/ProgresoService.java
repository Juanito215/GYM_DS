package com.gym.Gym.service;
import com.gym.Gym.model.Progreso;
import com.gym.Gym.repository.ProgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgresoService {

    @Autowired
    private ProgresoRepository progresoRepository;

    public Progreso registrarProgreso(Progreso progreso) { return progresoRepository.save(progreso); }

}
