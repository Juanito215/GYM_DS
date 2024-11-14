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
}
