package com.gym.Gym.controller;

import com.gym.Gym.model.Equipamiento;
import com.gym.Gym.service.EquipamientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equipamiento")
public class EquipamientoController {

    private final EquipamientoService equipamientoService;

    public EquipamientoController(EquipamientoService equipamientoService) {
        this.equipamientoService = equipamientoService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<Equipamiento> agregarEquipamiento(@RequestBody Equipamiento equipamiento) {
        Equipamiento nuevoEquipamiento = equipamientoService.agregarEquipamiento(equipamiento);
        return ResponseEntity.ok(nuevoEquipamiento);
    }

    @GetMapping("/listar-equipamiento")
    public ResponseEntity<?> listarEquipamiento() {
        return ResponseEntity.ok(equipamientoService.listarEquipamiento());
    }

    @GetMapping("/buscar-equipamiento/{id}")
    public ResponseEntity<?> buscarEquipamiento(@PathVariable Long id) {
        return ResponseEntity.ok(equipamientoService.buscarEquipamiento(id));
    }

    @PutMapping("/actualizar-equipamiento/{id}")
    public ResponseEntity<Equipamiento> actualizarEquipamiento(@PathVariable Long id, @RequestBody Equipamiento equipamientoActualizado) {
        Equipamiento equipamiento = equipamientoService.actualizarEquipamiento(id, equipamientoActualizado);
        return ResponseEntity.ok(equipamiento);
    }

}

