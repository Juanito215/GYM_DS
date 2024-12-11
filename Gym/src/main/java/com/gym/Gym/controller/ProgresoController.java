package com.gym.Gym.controller;

import com.gym.Gym.model.Progreso;
import com.gym.Gym.service.ProgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/progreso")
public class ProgresoController {

    private final ProgresoService progresoService;

    @Autowired
    public ProgresoController(ProgresoService progresoService) {
        this.progresoService = progresoService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<Progreso> agregarGimnasio(@RequestBody Progreso progreso) {
        Progreso nuevoProgreso = progresoService.registrarProgreso (progreso);
        return ResponseEntity.ok(nuevoProgreso);
    }

    @GetMapping("/listar-progresos")
    public ResponseEntity<List<Progreso>> listarProgresos() {
        List<Progreso> progresos = progresoService.listarProgresos();
        return ResponseEntity.ok(progresos);
    }

    @GetMapping("/buscar-progreso/{id}")
    public ResponseEntity<Progreso> buscarProgreso(@PathVariable Long id) {
        Progreso progreso = progresoService.buscarProgreso(id);
        return ResponseEntity.ok(progreso);
    }

    @PutMapping("/actualizar-progreso/{id}")
    public ResponseEntity<Progreso> actualizarProgreso(@PathVariable Long id, @RequestBody Progreso progreso) {
        Progreso progresoActualizado = progresoService.actualizarProgreso(id, progreso);
        return ResponseEntity.ok(progresoActualizado);
    }
}
