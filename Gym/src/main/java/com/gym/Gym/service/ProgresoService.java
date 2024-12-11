package com.gym.Gym.service;
import com.gym.Gym.model.Progreso;
import com.gym.Gym.repository.ProgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgresoService {

    @Autowired
    private ProgresoRepository progresoRepository;

    public Progreso registrarProgreso(Progreso progreso) {
        return progresoRepository.save(progreso);
    }

    public List<Progreso> listarProgresos() {
        return progresoRepository.findAll();
    }

    public Progreso buscarProgreso(Long id) {
        return progresoRepository.findById(id).orElse(null);
    }

    public Progreso actualizarProgreso(Long id, Progreso progreso) {
        Progreso progresoActual = progresoRepository.findById(id).orElse(null);
        if (progresoActual != null) {
            progresoActual.setPeso(progreso.getPeso());
            progresoActual.setPorcentaje_grasa(progreso.getPorcentaje_grasa());
            progresoActual.setComentarios(progreso.getComentarios());
            return progresoRepository.save(progresoActual);
        }
        return null;
    }

}
