package com.gym.Gym.service;

import com.gym.Gym.model.UsuariosRutinas;
import com.gym.Gym.model.Usuario;
import com.gym.Gym.model.Rutinas;
import com.gym.Gym.repository.UsuariosRutinasRepository;
import com.gym.Gym.repository.UsuarioRepository;
import com.gym.Gym.repository.RutinasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosRutinasService {

    private final UsuariosRutinasRepository usuariosRutinasRepository;
    private final UsuarioRepository usuarioRepository;
    private final RutinasRepository rutinasRepository;

    public UsuariosRutinasService(UsuariosRutinasRepository usuariosRutinasRepository,
                                  UsuarioRepository usuarioRepository,
                                  RutinasRepository rutinasRepository) {
        this.usuariosRutinasRepository = usuariosRutinasRepository;
        this.usuarioRepository = usuarioRepository;
        this.rutinasRepository = rutinasRepository;
    }

    // Crear una nueva asignación usuario-rutina
    public UsuariosRutinas agregarUsuarioRutina(UsuariosRutinas usuariosRutinas) {
        if (usuariosRutinas.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(usuariosRutinas.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + usuariosRutinas.getUsuarioId()));
            usuariosRutinas.setUsuario(usuario);
        }
        if (usuariosRutinas.getRutinaId() != null) {
            Rutinas rutina = rutinasRepository.findById(usuariosRutinas.getRutinaId())
                    .orElseThrow(() -> new RuntimeException("Rutina no encontrada con ID: " + usuariosRutinas.getRutinaId()));
            usuariosRutinas.setRutina(rutina);
        }

        return usuariosRutinasRepository.save(usuariosRutinas);
    }

    // Listar todas las asignaciones
    public List<UsuariosRutinas> listarUsuarioRutinas() {
        return usuariosRutinasRepository.findAll();
    }

    // Actualizar una asignación existente
    public UsuariosRutinas actualizarUsuarioRutina(Long id, UsuariosRutinas usuariosRutinasActualizado) {
        UsuariosRutinas existente = usuariosRutinasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada con ID: " + id));

        if (usuariosRutinasActualizado.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(usuariosRutinasActualizado.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + usuariosRutinasActualizado.getUsuarioId()));
            existente.setUsuario(usuario);
        }

        if (usuariosRutinasActualizado.getRutinaId() != null) {
            Rutinas rutina = rutinasRepository.findById(usuariosRutinasActualizado.getRutinaId())
                    .orElseThrow(() -> new RuntimeException("Rutina no encontrada con ID: " + usuariosRutinasActualizado.getRutinaId()));
            existente.setRutina(rutina);
        }

        existente.setFechaAsignacion(usuariosRutinasActualizado.getFechaAsignacion());
        existente.setProgreso(usuariosRutinasActualizado.getProgreso());

        return usuariosRutinasRepository.save(existente);
    }

    // Buscar una asignación por ID
    public UsuariosRutinas buscarUsuarioRutina(Long id) {
        return usuariosRutinasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada con ID: " + id));
    }
}
