package com.gym.Gym.controller;

import com.gym.Gym.model.UsuariosRutinas;
import com.gym.Gym.service.UsuariosRutinasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-rutinas")
@CrossOrigin("http://localhost:3000") //Modificar en caso de que su localhost del front sea diferente

public class UsuarioRutinasController {

    private final UsuariosRutinasService usuariosRutinasService;

    public UsuarioRutinasController(UsuariosRutinasService usuariosRutinasService) {
        this.usuariosRutinasService = usuariosRutinasService;
    }

    // Endpoint para agregar una nueva relación usuario-rutina
    @PostMapping("/agregar")
    public ResponseEntity<UsuariosRutinas> agregarUsuarioRutina(@RequestBody UsuariosRutinas usuariosRutinas) {
        UsuariosRutinas nuevaAsignacion = usuariosRutinasService.agregarUsuarioRutina(usuariosRutinas);
        return ResponseEntity.ok(nuevaAsignacion);
    }

    // Endpoint para listar todas las relaciones usuario-rutina
    @GetMapping("/listar")
    public ResponseEntity<List<UsuariosRutinas>> listarUsuarioRutinas() {
        return ResponseEntity.ok(usuariosRutinasService.listarUsuarioRutinas());
    }

    // Endpoint para actualizar una relación usuario-rutina
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuariosRutinas> actualizarUsuarioRutina(
            @PathVariable Long id,
            @RequestBody UsuariosRutinas usuariosRutinasActualizado) {
        UsuariosRutinas actualizado = usuariosRutinasService.actualizarUsuarioRutina(id, usuariosRutinasActualizado);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<UsuariosRutinas> buscarUsuarioRutina(@PathVariable Long id) {
        UsuariosRutinas usuariosRutinas = usuariosRutinasService.buscarUsuarioRutina(id);
        return ResponseEntity.ok(usuariosRutinas);
    }
}
