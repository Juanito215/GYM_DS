package com.gym.Gym.service;

import com.gym.Gym.model.Usuario;
import com.gym.Gym.repository.UsuarioRepository;
import jakarta.validation.constraints.Email;
import org.apache.naming.factory.SendMailFactory;
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
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }
        return usuarioRepository.save(usuario);
    }

    // Inicio de sesión
    public Optional<Usuario> loginUsuario(String email, String contrasena) {
        return usuarioRepository.findByEmail(email)
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
        if (usuario.getEmail() != null) usuarioExistente.setEmail(usuario.getEmail());
        if (usuario.getContrasena() != null) usuarioExistente.setContrasena(usuario.getContrasena());
        if (usuario.getObjetivo() != null) usuarioExistente.setObjetivo(usuario.getObjetivo());
        if (usuario.getTipo_anatomia() != null) usuarioExistente.setTipo_anatomia(usuario.getTipo_anatomia());
        if (usuario.getAltura() > 0) usuarioExistente.setAltura(usuario.getAltura());
        if (usuario.getPeso() > 0) usuarioExistente.setPeso(usuario.getPeso());
        if (usuario.getEdad() > 0) usuarioExistente.setEdad(usuario.getEdad());
        if (usuario.getAlimentacion() != null) usuarioExistente.setAlimentacion(usuario.getAlimentacion());

        return usuarioRepository.save(usuarioExistente);
    }
}
