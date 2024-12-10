//package com.gym.Gym.controller;
//
//import com.gym.Gym.model.Rutinas;
//import com.gym.Gym.service.RutinasService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/rutinas")
//public class RutinasController {
//
//    private final RutinasService rutinasService;
//
//    public RutinasController(RutinasService rutinasService) {
//        this.rutinasService = rutinasService;
//    }
//
//    @PostMapping("/agregar")
//    public ResponseEntity<Rutinas> agregarRutina(@RequestBody Rutinas rutinas) {
//        Rutinas nuevoRutina = rutinasService.registrarRutinas (rutinas);
//        return ResponseEntity.ok(nuevoRutina);
//    }
//
//}
