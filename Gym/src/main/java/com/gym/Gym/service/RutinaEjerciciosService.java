package com.gym.Gym.service;

import com.gym.Gym.model.RutinaEjercicios;
import com.gym.Gym.model.Rutinas;
import com.gym.Gym.model.Ejercicios;
import com.gym.Gym.repository.RutinaEjerciciosRepository;
import com.gym.Gym.repository.RutinasRepository;
import com.gym.Gym.repository.EjercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaEjerciciosService {

    private final RutinaEjerciciosRepository rutinaEjerciciosRepository;
    private final RutinasRepository rutinasRepository;
    private final EjercicioRepository ejerciciosRepository;

    public RutinaEjerciciosService(RutinaEjerciciosRepository rutinaEjerciciosRepository,
                                   RutinasRepository rutinasRepository,
                                   EjercicioRepository ejerciciosRepository) {
        this.rutinaEjerciciosRepository = rutinaEjerciciosRepository;
        this.rutinasRepository = rutinasRepository;
        this.ejerciciosRepository = ejerciciosRepository;
    }

    // Crear una nueva relación
    public RutinaEjercicios agregarRutinaEjercicio(RutinaEjercicios rutinaEjercicios) {
        if (rutinaEjercicios.getRutinaId() != null) {
            Rutinas rutina = rutinasRepository.findById(rutinaEjercicios.getRutinaId())
                    .orElseThrow(() -> new RuntimeException("Rutina no encontrada con ID: " + rutinaEjercicios.getRutinaId()));
            rutinaEjercicios.setRutina(rutina);
        }

        if (rutinaEjercicios.getEjercicioId() != null) {
            Ejercicios ejercicio = ejerciciosRepository.findById(rutinaEjercicios.getEjercicioId())
                    .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado con ID: " + rutinaEjercicios.getEjercicioId()));
            rutinaEjercicios.setEjercicio(ejercicio);
        }

        return rutinaEjerciciosRepository.save(rutinaEjercicios);
    }

    // Listar todas las relaciones
    public List<RutinaEjercicios> listarRutinaEjercicios() {
        return rutinaEjerciciosRepository.findAll();
    }

    // Buscar por ID
    public RutinaEjercicios buscarRutinaEjercicioPorId(Long id) {
        return rutinaEjerciciosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RutinaEjercicio no encontrada con ID: " + id));
    }

    // Actualizar una relación existente
    public RutinaEjercicios actualizarRutinaEjercicio(Long id, RutinaEjercicios rutinaEjerciciosActualizado) {
        RutinaEjercicios existente = rutinaEjerciciosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RutinaEjercicio no encontrada con ID: " + id));

        if (rutinaEjerciciosActualizado.getRutinaId() != null) {
            Rutinas rutina = rutinasRepository.findById(rutinaEjerciciosActualizado.getRutinaId())
                    .orElseThrow(() -> new RuntimeException("Rutina no encontrada con ID: " + rutinaEjerciciosActualizado.getRutinaId()));
            existente.setRutina(rutina);
        }

        if (rutinaEjerciciosActualizado.getEjercicioId() != null) {
            Ejercicios ejercicio = ejerciciosRepository.findById(rutinaEjerciciosActualizado.getEjercicioId())
                    .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado con ID: " + rutinaEjerciciosActualizado.getEjercicioId()));
            existente.setEjercicio(ejercicio);
        }

        existente.setRepeticiones(rutinaEjerciciosActualizado.getRepeticiones());
        existente.setSeries(rutinaEjerciciosActualizado.getSeries());

        return rutinaEjerciciosRepository.save(existente);
    }

}
