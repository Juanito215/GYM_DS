package com.gym.Gym.service;

import com.gym.Gym.model.Equipamiento;
import com.gym.Gym.repository.EquipamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamientoService  {

    @Autowired
    private EquipamientoRepository equipamientoRepository;

    public Equipamiento registrarEquipamiento(Equipamiento equipamiento) { return equipamientoRepository.save(equipamiento); }
}
