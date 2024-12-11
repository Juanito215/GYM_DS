package com.gym.Gym.controller;

import com.gym.Gym.model.Rutinas;
import com.gym.Gym.service.RutinasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rutinas")
@CrossOrigin("http://localhost:3000")
public class RutinasController {

    private final RutinasService rutinasService;

    public RutinasController(RutinasService rutinasService) {
        this.rutinasService = rutinasService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<Rutinas> agregarRutina(@RequestBody Rutinas rutinas) {
        Rutinas nuevoRutina = rutinasService.registrarRutinas (rutinas);
        return ResponseEntity.ok(nuevoRutina);
    }

    @GetMapping("/listar-rutinas")
    public ResponseEntity<?> listarRutinas() {
        return ResponseEntity.ok(rutinasService.listarRutinas());
    }

    @GetMapping("/buscar-rutina/{nombre}")
    public ResponseEntity<?> buscarRutina(@PathVariable String nombre) {
        return ResponseEntity.ok(rutinasService.buscarRutina(nombre));
    }

    @PutMapping("/actualizar-rutina/{id}")
    public ResponseEntity<?> actualizarRutina(@PathVariable Long id, @RequestBody Rutinas rutinas) {
        return ResponseEntity.ok(rutinasService.actualizarRutina(id, rutinas));
    }

}
