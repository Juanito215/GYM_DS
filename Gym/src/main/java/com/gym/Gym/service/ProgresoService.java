package com.gym.Gym.service;

import com.gym.Gym.model.Progreso;
import com.gym.Gym.model.Usuario;
import com.gym.Gym.repository.ProgresoRepository;
import com.gym.Gym.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgresoService {

    private final ProgresoRepository progresoRepository;
    private final UsuarioRepository usuarioRepository;

    public ProgresoService(ProgresoRepository progresoRepository, UsuarioRepository usuarioRepository) {
        this.progresoRepository = progresoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Método para agregar un progreso
    public Progreso agregarProgreso(Progreso progreso) {
        // Buscar el usuario por ID antes de asociarlo
        if (progreso.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(progreso.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + progreso.getUsuarioId()));
            progreso.setUsuario(usuario);
        }
        return progresoRepository.save(progreso);
    }

    // Listar todos los progresos
    public List<Progreso> listarProgresos() {
        return progresoRepository.findAll();
    }

    // Actualizar un progreso
    public Progreso actualizarProgreso(Long id, Progreso progresoActualizado) {
        // Buscar el progreso existente
        Progreso progresoExistente = progresoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Progreso no encontrado con ID: " + id));

        // Actualizar los campos básicos
        progresoExistente.setPeso(progresoActualizado.getPeso());
        progresoExistente.setPorcentaje_grasa(progresoActualizado.getPorcentaje_grasa());
        progresoExistente.setComentarios(progresoActualizado.getComentarios());

        // Actualizar la referencia al usuario si se incluye un nuevo ID
        if (progresoActualizado.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(progresoActualizado.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + progresoActualizado.getUsuarioId()));
            progresoExistente.setUsuario(usuario);
        }

        return progresoRepository.save(progresoExistente);
    }

    // Buscar un progreso por ID
    public Progreso buscarProgreso(Long id) {
        return progresoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Progreso no encontrado con ID: " + id));
    }
}
