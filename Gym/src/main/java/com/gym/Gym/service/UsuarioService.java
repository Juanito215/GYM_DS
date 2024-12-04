package com.gym.Gym.service;

import com.gym.Gym.model.Usuario;
import com.gym.Gym.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Registro de un nuevo usuario
    public Usuario registrarUsuario(Usuario usuario) {
        // Podrías validar aquí si ya existe un usuario con el mismo correo
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }
        return usuarioRepository.save(usuario);
    }

    // Inicio de sesión
    public Optional<Usuario> loginUsuario(String correo, String contrasena) {
        return usuarioRepository.findByCorreo(correo)
                .filter(u -> u.getContrasena().equals(contrasena))
                .map(u -> {
                    System.out.println("Usuario autenticado: " + u.getNombre());
                    return u;
                });
    }

    // Buscar usuario por ID
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El usuario con id: " + id + " no existe"));
    }

    // Actualizar usuario existente
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioExistente = buscarUsuarioPorId(id); // Reutiliza el método buscarUsuarioPorId

        // Actualiza los campos
        if (usuario.getNombre() != null) usuarioExistente.setNombre(usuario.getNombre());
        if (usuario.getGenero() != null) usuarioExistente.setGenero(usuario.getGenero());
        if (usuario.getCorreo() != null) usuarioExistente.setCorreo(usuario.getCorreo());
        if (usuario.getContrasena() != null) usuarioExistente.setContrasena(usuario.getContrasena());
        if (usuario.getObjetivo() != null) usuarioExistente.setObjetivo(usuario.getObjetivo());
        if (usuario.getAnatomia() != null) usuarioExistente.setAnatomia(usuario.getAnatomia());
        if (usuario.getAltura() > 0) usuarioExistente.setAltura(usuario.getAltura());
        if (usuario.getPeso() > 0) usuarioExistente.setPeso(usuario.getPeso());
        if (usuario.getEdad() > 0) usuarioExistente.setEdad(usuario.getEdad());
        if (usuario.getAlimentacion() != null) usuarioExistente.setAlimentacion(usuario.getAlimentacion());

        return usuarioRepository.save(usuarioExistente);
    }
}
