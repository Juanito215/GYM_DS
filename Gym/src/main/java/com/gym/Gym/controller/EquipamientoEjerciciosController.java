package com.gym.Gym.controller;

import com.gym.Gym.model.EquipamientoEjercicios;
import com.gym.Gym.service.EquipamientoEjerciciosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamiento-ejercicios")
@CrossOrigin("http://localhost:3000") //Modificar en caso de que su localhost del front sea diferente

public class EquipamientoEjerciciosController {

    private final EquipamientoEjerciciosService equipamientoEjerciciosService;

    public EquipamientoEjerciciosController(EquipamientoEjerciciosService equipamientoEjerciciosService) {
        this.equipamientoEjerciciosService = equipamientoEjerciciosService;
    }

    // Crear una nueva relación
    @PostMapping("/agregar")
    public ResponseEntity<EquipamientoEjercicios> agregarEquipamientoEjercicio(@RequestBody EquipamientoEjercicios equipamientoEjercicios) {
        EquipamientoEjercicios nuevo = equipamientoEjerciciosService.agregarEquipamientoEjercicio(equipamientoEjercicios);
        return ResponseEntity.ok(nuevo);
    }

    // Listar todas las relaciones
    @GetMapping("/listar")
    public ResponseEntity<List<EquipamientoEjercicios>> listarEquipamientoEjercicios() {
        return ResponseEntity.ok(equipamientoEjerciciosService.listarEquipamientoEjercicios());
    }

    // Buscar una relación por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<EquipamientoEjercicios> buscarEquipamientoEjercicioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(equipamientoEjerciciosService.buscarEquipamientoEjercicioPorId(id));
    }

    // Actualizar una relación existente
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EquipamientoEjercicios> actualizarEquipamientoEjercicio(@PathVariable Long id, @RequestBody EquipamientoEjercicios equipamientoEjercicios) {
        EquipamientoEjercicios actualizado = equipamientoEjerciciosService.actualizarEquipamientoEjercicio(id, equipamientoEjercicios);
        return ResponseEntity.ok(actualizado);
    }

}
