package com.gym.Gym.controller;

import com.gym.Gym.model.RutinaEjercicios;
import com.gym.Gym.service.RutinaEjerciciosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutina-ejercicios")
public class RutinaEjerciciosController {

    private final RutinaEjerciciosService rutinaEjerciciosService;

    public RutinaEjerciciosController(RutinaEjerciciosService rutinaEjerciciosService) {
        this.rutinaEjerciciosService = rutinaEjerciciosService;
    }

    @PostMapping("/agregar")
    public RutinaEjercicios agregarRutinaEjercicio(@RequestBody RutinaEjercicios rutinaEjercicios) {
        return rutinaEjerciciosService.agregarRutinaEjercicio(rutinaEjercicios);
    }

    @GetMapping("/listar")
    public List<RutinaEjercicios> listarRutinaEjercicios() {
        return rutinaEjerciciosService.listarRutinaEjercicios();
    }

    @GetMapping("/buscar/{id}")
    public RutinaEjercicios buscarRutinaEjercicioPorId(@PathVariable Long id) {
        return rutinaEjerciciosService.buscarRutinaEjercicioPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public RutinaEjercicios actualizarRutinaEjercicio(@PathVariable Long id, @RequestBody RutinaEjercicios rutinaEjercicios) {
        return rutinaEjerciciosService.actualizarRutinaEjercicio(id, rutinaEjercicios);
    }


}
