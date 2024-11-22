package com.gym.Gym.service;

import com.gym.Gym.model.Gimnasio;
import com.gym.Gym.repository.GimnasioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GimnasioService {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    public Gimnasio registrarGimnasio(Gimnasio gimnasio) { return gimnasioRepository.save(gimnasio); }

}
