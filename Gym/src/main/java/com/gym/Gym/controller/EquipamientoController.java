package com.gym.Gym.controller;

import com.gym.Gym.model.Equipamiento;
import com.gym.Gym.service.EquipamientoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        Equipamiento nuevoGimnasio = equipamientoService.registrarEquipamiento (equipamiento);
        return ResponseEntity.ok(nuevoGimnasio);
    }
}
