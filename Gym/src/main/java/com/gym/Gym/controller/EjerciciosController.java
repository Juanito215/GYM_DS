package com.gym.Gym.controller;

import com.gym.Gym.model.Ejercicios;
import com.gym.Gym.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ejercicios")
public class EjerciciosController {

    @Autowired
    private EjercicioService ejercicioService;

    // Agregar un ejercicio
    @PostMapping("/agregar")
    public ResponseEntity<Ejercicios> agregarEjercicio(@RequestBody Ejercicios ejercicio) {
        try {
            // Registrar el ejercicio llamando al servicio
            Ejercicios nuevoEjercicio = ejercicioService.registrarEjercicio(ejercicio);
            return ResponseEntity.ok(nuevoEjercicio);
        } catch (IllegalArgumentException e) {
            // Capturar excepciones y devolver una respuesta de error
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Obtener todos los ejercicios
    @GetMapping("/todos")
    public ResponseEntity<List<Ejercicios>> obtenerTodosEjercicios() {
        List<Ejercicios> ejercicios = ejercicioService.obtenerTodosEjercicios();
        return ResponseEntity.ok(ejercicios);
    }

    // Obtener ejercicios por zona del cuerpo
    @GetMapping("/por-zona-cuerpo")
    public ResponseEntity<Optional<Ejercicios>> obtenerEjerciciosPorZonaCuerpo(@RequestParam String zonaCuerpo) {
        Optional<Ejercicios> ejercicios = ejercicioService.obtenerEjerciciosPorZonaCuerpo(zonaCuerpo);
        return ResponseEntity.ok(ejercicios);
    }

    // Actualizar un ejercicio
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Ejercicios> actualizarEjercicio(@PathVariable Long id, @RequestBody Ejercicios ejercicioActualizado) {
        try {
            Ejercicios ejercicio = ejercicioService.actualizarEjercicio(id, ejercicioActualizado);
            return ResponseEntity.ok(ejercicio);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Eliminar un ejercicio
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEjercicio(@PathVariable Long id) {
        try {
            ejercicioService.eliminarEjercicio(id);
            return ResponseEntity.noContent().build(); // Respuesta exitosa sin contenido
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // Respuesta de error si no se encuentra el ejercicio
        }
    }
}
