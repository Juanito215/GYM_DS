package com.gym.Gym.controller;

import com.gym.Gym.model.Ejercicios;
import com.gym.Gym.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ejercicios")
public class EjerciciosController {

    @Autowired
    private EjercicioService ejercicioService;

    @PostMapping("/agregar")
    public ResponseEntity<Ejercicios> agregarEjercicio(@RequestBody Ejercicios ejercicio) {
        Ejercicios nuevoEjercicio = ejercicioService.registrarEjercicio(ejercicio);
        return ResponseEntity.ok(nuevoEjercicio);
    }
}
