package com.gym.Gym.service;

import com.gym.Gym.model.Ejercicios;
import com.gym.Gym.repository.EjercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {

    private final EjercicioRepository ejerciciosRepository;

    public EjercicioService(EjercicioRepository ejerciciosRepository) {
        this.ejerciciosRepository = ejerciciosRepository;
    }

    public Ejercicios agregarEjercicio(Ejercicios ejercicios) {
        return ejerciciosRepository.save(ejercicios);
        
    }

    public List<Ejercicios> listarEjercicios() {
        return ejerciciosRepository.findAll();
    }

    public Ejercicios buscarEjercicio(String nombre) {
        return ejerciciosRepository.findByNombre(nombre).orElseThrow(() -> new RuntimeException("Ejercicio no encontrado"));
    }

    public Ejercicios actualizarEjercicio(String nombre, Ejercicios ejercicios) {
        Ejercicios ejercicios1 = ejerciciosRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado: " + nombre));

        ejercicios1.setNombre(ejercicios.getNombre());
        ejercicios1.setDescripcion(ejercicios.getDescripcion());
        ejercicios1.setRepeticiones(ejercicios.getRepeticiones());
        ejercicios1.setSeries(ejercicios.getSeries());

        return ejerciciosRepository.save(ejercicios1);

    }


}
