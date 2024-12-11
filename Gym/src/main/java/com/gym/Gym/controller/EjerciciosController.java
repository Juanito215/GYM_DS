package com.gym.Gym.controller;

import com.gym.Gym.model.Ejercicios;
import com.gym.Gym.service.EjercicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicios")
public class EjerciciosController {

    private final EjercicioService ejerciciosService;

    public EjerciciosController(EjercicioService ejerciciosService) {
        this.ejerciciosService = ejerciciosService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<Ejercicios> agregarEjercicio(@RequestBody Ejercicios ejercicios) {
        return ResponseEntity.ok(ejerciciosService.agregarEjercicio(ejercicios));
    }

    @GetMapping("/listar-ejercicios")
    public ResponseEntity<List<Ejercicios>> listarEjercicios() {
        return ResponseEntity.ok(ejerciciosService.listarEjercicios());
    }

    @GetMapping("/buscar-ejercicio/{nombre}")
    public ResponseEntity<Ejercicios> buscarEjercicio(@PathVariable String nombre) {
        return ResponseEntity.ok(ejerciciosService.buscarEjercicio(nombre));
    }

    @PutMapping("/actualizar-ejercicio/{nombre}")
    public ResponseEntity<?> actualizarEjercicio(@PathVariable String nombre, @RequestBody Ejercicios ejercicios) {
        try {
            Ejercicios ejercicioActualizado = ejerciciosService.actualizarEjercicio(nombre, ejercicios);
            return ResponseEntity.ok(ejercicioActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


}
