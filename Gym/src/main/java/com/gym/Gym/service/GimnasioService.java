package com.gym.Gym.service;

import com.gym.Gym.model.Gimnasio;
import com.gym.Gym.repository.GimnasioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GimnasioService {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    public Gimnasio registrarGimnasio(Gimnasio gimnasio) {
        return gimnasioRepository.save(gimnasio); }

    public List<Gimnasio> listarGimnasios() {
        return gimnasioRepository.findAll();
    }

    public Gimnasio buscarGimnasio(String nombre) {
        return gimnasioRepository.findByNombre(nombre).orElse(null);
    }

    public Gimnasio actualizarGimnasio(Long id, Gimnasio gimnasioDetalles) {
        Gimnasio gimnasioExistente = gimnasioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gimnasio no encontrado con id: " + id));

        gimnasioExistente.setNombre(gimnasioDetalles.getNombre());
        gimnasioExistente.setDireccion(gimnasioDetalles.getDireccion());
        gimnasioExistente.setTelefono(gimnasioDetalles.getTelefono());

        return gimnasioRepository.save(gimnasioExistente);
    }

}
