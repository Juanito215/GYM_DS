//package com.gym.Gym.controller;
//
//import com.gym.Gym.model.Gimnasio;
//import com.gym.Gym.service.GimnasioService;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/gimnasio")
//
//public class GimnasioController {
//
//    private final GimnasioService gimnasioService;
//
//    public GimnasioController(GimnasioService gimnasioService) {
//        this.gimnasioService = gimnasioService;
//    }
//
//    @PostMapping("/agregar")
//    public ResponseEntity<Gimnasio> agregarGimnasio(@RequestBody Gimnasio gimnasio) {
//        Gimnasio nuevoGimnasio = gimnasioService.registrarGimnasio (gimnasio);
//        return ResponseEntity.ok(nuevoGimnasio);
//    }
//}
