package com.gym.Gym.controller;

import com.gym.Gym.model.Gimnasio;
import com.gym.Gym.service.GimnasioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000") //Modificar en caso de que su localhost del front sea diferente

@RequestMapping("/api/gimnasio")

public class GimnasioController {

    private final GimnasioService gimnasioService;

    public GimnasioController(GimnasioService gimnasioService) {
        this.gimnasioService = gimnasioService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<Gimnasio> agregarGimnasio(@RequestBody Gimnasio gimnasio) {
        Gimnasio nuevoGimnasio = gimnasioService.registrarGimnasio (gimnasio);
        return ResponseEntity.ok(nuevoGimnasio);
    }

    @GetMapping("/listar-gimnasios")
    public ResponseEntity<List<Gimnasio>> listarGimnasios() {
        List<Gimnasio> gimnasios = gimnasioService.listarGimnasios();
        return ResponseEntity.ok(gimnasios);
    }

    @GetMapping("/buscar-gimnasio/{nombre}")
    public ResponseEntity<Gimnasio> buscarGimnasio(@PathVariable String nombre) {
        Gimnasio gimnasio = gimnasioService.buscarGimnasio(nombre);
        return ResponseEntity.ok(gimnasio);
    }

    @PutMapping("/actualizar-gimnasio/{id}")
    public ResponseEntity<Gimnasio> actualizarGimnasio(@PathVariable("id") Long id, @RequestBody Gimnasio gimnasio) {
        Gimnasio gimnasioActualizado = gimnasioService.actualizarGimnasio(id, gimnasio);
        return ResponseEntity.ok(gimnasioActualizado);
    }

}
