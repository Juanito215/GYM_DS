package com.gym.Gym.controller;

import com.gym.Gym.model.Progreso;
import com.gym.Gym.service.ProgresoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progreso")
@CrossOrigin("http://localhost:3000") //Modificar en caso de que su localhost del front sea diferente

public class ProgresoController {

    private final ProgresoService progresoService;

    public ProgresoController(ProgresoService progresoService) {
        this.progresoService = progresoService;
    }

    // Endpoint para agregar un progreso
    @PostMapping("/agregar")
    public ResponseEntity<Progreso> agregarProgreso(@RequestBody Progreso progreso) {
        Progreso nuevoProgreso = progresoService.agregarProgreso(progreso);
        return ResponseEntity.ok(nuevoProgreso);
    }

    // Endpoint para listar todos los progresos
    @GetMapping("/listar-progreso")
    public ResponseEntity<List<Progreso>> listarProgresos() {
        return ResponseEntity.ok(progresoService.listarProgresos());
    }

    @GetMapping("/buscar-progreso/{id}")
    public ResponseEntity<Progreso> buscarProgreso(@PathVariable Long id) {
        Progreso progreso = progresoService.buscarProgreso(id);
        return ResponseEntity.ok(progreso);
    }

    // Endpoint para actualizar un progreso
    @PutMapping("/actualizar-progreso/{id}")
    public ResponseEntity<Progreso> actualizarProgreso(@PathVariable Long id, @RequestBody Progreso progresoActualizado) {
        Progreso progreso = progresoService.actualizarProgreso(id, progresoActualizado);
        return ResponseEntity.ok(progreso);
    }
}
