package com.gym.Gym.service;

import com.gym.Gym.model.EquipamientoEjercicios;
import com.gym.Gym.model.Equipamiento;
import com.gym.Gym.model.Ejercicios;
import com.gym.Gym.repository.EquipamientoEjerciciosRepository;
import com.gym.Gym.repository.EquipamientoRepository;
import com.gym.Gym.repository.EjercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamientoEjerciciosService {

    private final EquipamientoEjerciciosRepository equipamientoEjerciciosRepository;
    private final EquipamientoRepository equipamientoRepository;
    private final EjercicioRepository ejercicioRepository;

    public EquipamientoEjerciciosService(EquipamientoEjerciciosRepository equipamientoEjerciciosRepository,
                                         EquipamientoRepository equipamientoRepository,
                                         EjercicioRepository ejercicioRepository) {
        this.equipamientoEjerciciosRepository = equipamientoEjerciciosRepository;
        this.equipamientoRepository = equipamientoRepository;
        this.ejercicioRepository = ejercicioRepository;
    }

    // Crear una nueva relación equipamiento-ejercicio
    public EquipamientoEjercicios agregarEquipamientoEjercicio(EquipamientoEjercicios equipamientoEjercicios) {
        if (equipamientoEjercicios.getEquipamientoId() != null) {
            Equipamiento equipamiento = equipamientoRepository.findById(equipamientoEjercicios.getEquipamientoId())
                    .orElseThrow(() -> new RuntimeException("Equipamiento no encontrado con ID: " + equipamientoEjercicios.getEquipamientoId()));
            equipamientoEjercicios.setEquipamiento(equipamiento);
        }
        if (equipamientoEjercicios.getEjercicioId() != null) {
            Ejercicios ejercicio = ejercicioRepository.findById(equipamientoEjercicios.getEjercicioId())
                    .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado con ID: " + equipamientoEjercicios.getEjercicioId()));
            equipamientoEjercicios.setEjercicio(ejercicio);
        }

        return equipamientoEjerciciosRepository.save(equipamientoEjercicios);
    }

    // Listar todas las relaciones equipamiento-ejercicio
    public List<EquipamientoEjercicios> listarEquipamientoEjercicios() {
        return equipamientoEjerciciosRepository.findAll();
    }

    // Buscar relación por ID
    public EquipamientoEjercicios buscarEquipamientoEjercicioPorId(Long id) {
        return equipamientoEjerciciosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relación no encontrada con ID: " + id));
    }

    // Actualizar una relación existente
    public EquipamientoEjercicios actualizarEquipamientoEjercicio(Long id, EquipamientoEjercicios equipamientoEjerciciosActualizado) {
        EquipamientoEjercicios existente = equipamientoEjerciciosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relación no encontrada con ID: " + id));

        if (equipamientoEjerciciosActualizado.getEquipamientoId() != null) {
            Equipamiento equipamiento = equipamientoRepository.findById(equipamientoEjerciciosActualizado.getEquipamientoId())
                    .orElseThrow(() -> new RuntimeException("Equipamiento no encontrado con ID: " + equipamientoEjerciciosActualizado.getEquipamientoId()));
            existente.setEquipamiento(equipamiento);
        }

        if (equipamientoEjerciciosActualizado.getEjercicioId() != null) {
            Ejercicios ejercicio = ejercicioRepository.findById(equipamientoEjerciciosActualizado.getEjercicioId())
                    .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado con ID: " + equipamientoEjerciciosActualizado.getEjercicioId()));
            existente.setEjercicio(ejercicio);
        }

        existente.setDescripcion(equipamientoEjerciciosActualizado.getDescripcion());

        return equipamientoEjerciciosRepository.save(existente);
    }

}
