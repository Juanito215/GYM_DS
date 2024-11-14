package com.gym.Gym.controller;

import com.gym.Gym.model.Usuario;
import com.gym.Gym.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para registrar un nuevo usuario
    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Endpoint para iniciar sesión
    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioService.loginUsuario(usuario.getCorreo(), usuario.getContrasena());
        if (usuarioExistente.isPresent()) {
            // Si el inicio de sesión es exitoso, imprimirá en consola desde el servicio
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}
