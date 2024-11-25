package com.gym.Gym.controller;

import com.gym.Gym.model.Equipamiento;
import com.gym.Gym.service.EquipamientoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamiento")
public class EquipamientoController {

    private final EquipamientoService equipamientoService;

    public EquipamientoController(EquipamientoService equipamientoService) {
        this.equipamientoService = equipamientoService;
    }

    // Crear un nuevo equipamiento
    @PostMapping("/agregar")
    public ResponseEntity<Equipamiento> agregarEquipamiento(@RequestBody Equipamiento equipamiento) {
        Equipamiento nuevoEquipamiento = equipamientoService.registrarEquipamiento(equipamiento);
        return ResponseEntity.ok(nuevoEquipamiento);
    }

    // Listar todos los equipamientos
    @GetMapping
    public ResponseEntity<List<Equipamiento>> obtenerTodosEquipamientos() {
        List<Equipamiento> equipamientos = equipamientoService.obtenerTodosEquipamientos();
        return ResponseEntity.ok(equipamientos);
    }

    // Actualizar un equipamiento existente
    @PutMapping("/{id}")
    public ResponseEntity<Equipamiento> actualizarEquipamiento(
            @PathVariable Long id,
            @RequestBody Equipamiento equipamientoActualizado) {
        Equipamiento actualizado = equipamientoService.actualizarEquipamiento(id, equipamientoActualizado);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar un equipamiento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipamiento(@PathVariable Long id) {
        equipamientoService.eliminarEquipamiento(id);
        return ResponseEntity.noContent().build();
    }
}

