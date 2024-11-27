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

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> loginUsuario(String correo, String contrasena) {
        Optional<Usuario> usuarios = usuarioRepository.findByCorreo(correo)
                .filter(u -> u.getContrasena().equals(contrasena));

        usuarios.ifPresent(u -> System.out.println("Usuario autenticado: " + u));

        return usuarios;
    }


    public Usuario UsuarioExistente(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El usuario con id:" + id + "no existe"));
    }

    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        return usuarioRepository.findById(id)
                .map(u -> {
                    u.setNombre(usuario.getNombre());
                    u.setGenero(usuario.getGenero());
                    u.setCorreo(usuario.getCorreo());
                    u.setContrasena(usuario.getContrasena());
                    u.setObjetivo(usuario.getObjetivo());
                    u.setAnatomia(usuario.getAnatomia());
                    u.setAltura(usuario.getAltura());
                    u.setPeso(usuario.getPeso());
                    u.setEdad(usuario.getEdad());
                    u.setAlimentacion(usuario.getAlimentacion());
                    return usuarioRepository.save(u);
                })
                .orElseThrow(() -> new RuntimeException("El usuario con id:" + id + "no existe"));


    }
}
