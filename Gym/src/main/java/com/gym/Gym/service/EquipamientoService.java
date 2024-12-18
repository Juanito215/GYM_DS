package com.gym.Gym.service;

import com.gym.Gym.model.Equipamiento;
import com.gym.Gym.model.Gimnasio;
import com.gym.Gym.repository.EquipamientoRepository;
import com.gym.Gym.repository.GimnasioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        // Asignar el gimnasio recuperado al objeto equipamiento
        // Guardar el equipamiento en la base de datos
        return equipamientoRepository.save(equipamiento);
    }

    public List<Equipamiento> listarEquipamiento() {
        return equipamientoRepository.findAll();
    }

    public Equipamiento buscarEquipamiento(Long id) {
        return equipamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamiento no encontrado con ID: " + id));
    }

    public Equipamiento actualizarEquipamiento(Long id, Equipamiento equipamientoActualizado) {
        // Buscar el equipamiento por ID
        Equipamiento equipamientoExistente = equipamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamiento no encontrado con ID: " + id));

        // Actualizar los campos básicos
        equipamientoExistente.setNombre(equipamientoActualizado.getNombre());
        // Validar y asignar el gimnasio
        if (equipamientoActualizado.getGimnasio() != null) {
            Long gimnasioId = equipamientoActualizado.getGimnasio().getId_gym();
            Gimnasio gimnasio = gimnasioRepository.findById(gimnasioId)
                    .orElseThrow(() -> new RuntimeException("Gimnasio no encontrado con ID: " + gimnasioId));
            equipamientoExistente.setGimnasio(gimnasio);
        }

        // Guardar los cambios en la base de datos
        return equipamientoRepository.save(equipamientoExistente);
    }


}
