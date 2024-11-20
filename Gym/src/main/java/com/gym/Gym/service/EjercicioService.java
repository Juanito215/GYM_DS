package com.gym.Gym.service;

import com.gym.Gym.model.Ejercicios;
import com.gym.Gym.repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;


    public Ejercicios registrarEjercicio(Ejercicios ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }
}
