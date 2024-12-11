package com.gym.Gym.service;

import com.gym.Gym.model.Rutinas;
import com.gym.Gym.repository.RutinasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinasService {

    @Autowired
    private RutinasRepository rutinasRepository;


    public RutinasService(RutinasRepository rutinasRepository) {
        this.rutinasRepository = rutinasRepository;
    }
    public Rutinas registrarRutinas(Rutinas rutinas) {
        return rutinasRepository.save(rutinas);
    }

    public List<Rutinas> listarRutinas() {
        return rutinasRepository.findAll();
    }

    public Rutinas buscarRutina(String nombre) {
        return rutinasRepository.findByNombre(nombre).orElse(null);
    }

    public Rutinas actualizarRutina(Long id, Rutinas rutinas) {
        Rutinas rutina = rutinasRepository.findById(id).orElse(null);
        if (rutina != null) {
            rutina.setNombre(rutinas.getNombre());
            rutina.setObjetivo(rutinas.getObjetivo());
            rutina.setDescripcion(rutinas.getDescripcion());
            rutina.setNivel_entrenamiento(rutinas.getNivel_entrenamiento());
            return rutinasRepository.save(rutina);
        }
        return null;
    }


}
