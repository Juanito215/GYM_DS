package com.gym.Gym.service;

import com.gym.Gym.model.Equipamiento;
import com.gym.Gym.model.Gimnasio;
import com.gym.Gym.repository.EquipamientoRepository;
import com.gym.Gym.repository.GimnasioRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipamientoService {

    private final EquipamientoRepository equipamientoRepository;
    private final GimnasioRepository gimnasioRepository;

    public EquipamientoService(EquipamientoRepository equipamientoRepository, GimnasioRepository gimnasioRepository) {
        this.equipamientoRepository = equipamientoRepository;
        this.gimnasioRepository = gimnasioRepository;
    }

    public Equipamiento agregarEquipamiento(Equipamiento equipamiento) {
        // Recuperar el gimnasio por gimnasioId
        Long gimnasioId = equipamiento.getGimnasioId();
        Gimnasio gimnasio = gimnasioRepository.findById(gimnasioId)
                .orElseThrow(() -> new RuntimeException("Gimnasio no encontrado con ID: " + gimnasioId));

        // Asignar el gimnasio recuperado al objeto equipamiento
        equipamiento.setGimnasio(gimnasio);

        // Guardar el equipamiento en la base de datos
        return equipamientoRepository.save(equipamiento);
    }
}
