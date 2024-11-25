package com.gym.Gym.service;

import com.gym.Gym.model.Ejercicios;
import com.gym.Gym.model.Equipamiento;
import com.gym.Gym.repository.EjercicioRepository;
import com.gym.Gym.repository.EquipamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Autowired
    private EquipamientoRepository equipamientoRepository;

    // Método para registrar un nuevo ejercicio
    public Ejercicios registrarEjercicio(Ejercicios ejercicio) {
        // Validación: Verificar si el ejercicio ya existe por nombre
        if (ejercicioRepository.findByNombre(ejercicio.getNombre()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un ejercicio con el nombre: " + ejercicio.getNombre());
        }

        // Validación: Verificar que todos los equipamientos asociados al ejercicio existan
        for (Equipamiento equipamiento : ejercicio.getEquipamientos()) {
            if (!equipamientoRepository.existsById(equipamiento.getId())) {
                throw new IllegalArgumentException("Uno de los equipamientos no existe.");
            }
        }

        // Guardar el ejercicio
        return ejercicioRepository.save(ejercicio);
    }

    // Método para obtener todos los ejercicios
    public List<Ejercicios> obtenerTodosEjercicios() {
        return ejercicioRepository.findAll();
    }

    // Método para actualizar un ejercicio
    public Ejercicios actualizarEjercicio(Long id, Ejercicios ejercicioActualizado) {
        Ejercicios ejercicioExistente = ejercicioRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No se encontró el ejercicio con ID: " + id));

        ejercicioExistente.setNombre(ejercicioActualizado.getNombre());
        ejercicioExistente.setDescripcion(ejercicioActualizado.getDescripcion());
        ejercicioExistente.setZona_cuerpo(ejercicioActualizado.getZona_cuerpo());
        ejercicioExistente.setEquipamientos(ejercicioActualizado.getEquipamientos());

        // Validación: Verificar que todos los equipamientos asociados al ejercicio existan
        for (Equipamiento equipamiento : ejercicioExistente.getEquipamientos()) {
            if (!equipamientoRepository.existsById(equipamiento.getId())) {
                throw new IllegalArgumentException("Uno de los equipamientos no existe.");
            }
        }

        // Guardar los cambios
        return ejercicioRepository.save(ejercicioExistente);
    }

    // Método para obtener ejercicios por zona del cuerpo
    public List<Ejercicios> obtenerEjerciciosPorZonaCuerpo(String zonaCuerpo) {
        return ejercicioRepository.findByZonaCuerpo(zonaCuerpo);
    }

    // Método para eliminar un ejercicio
    public void eliminarEjercicio(Long id) {
        if (!ejercicioRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró el ejercicio con ID: " + id);
        }
        ejercicioRepository.deleteById(id);
    }
}
