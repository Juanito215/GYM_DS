//package com.gym.Gym.controller;
//
//
//import com.gym.Gym.model.Progreso;
//import com.gym.Gym.service.ProgresoService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/api/progreso")
//public class ProgresoController {
//
//    private final ProgresoService progresoService;
//
//    public ProgresoController(ProgresoService progresoService) {
//        this.progresoService = progresoService;
//    }
//
//    @PostMapping("/agregar")
//    public ResponseEntity<Progreso> agregarGimnasio(@RequestBody Progreso progreso) {
//        Progreso nuevoProgreso = progresoService.registrarProgreso (progreso);
//        return ResponseEntity.ok(nuevoProgreso);
//    }
//}
