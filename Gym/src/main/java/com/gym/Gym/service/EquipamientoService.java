//package com.gym.Gym.service;
//
//import com.gym.Gym.model.Equipamiento;
//import com.gym.Gym.repository.EquipamientoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class EquipamientoService  {
//
//    @Autowired
//    private EquipamientoRepository equipamientoRepository;
//
//    public Equipamiento registrarEquipamiento(Equipamiento equipamiento) {
//        // Validación: Verificar que el nombre no esté vacío
//        if (equipamiento.getNombre() == null || equipamiento.getNombre().isBlank()) {
//            throw new IllegalArgumentException("El nombre del equipamiento no puede estar vacío.");
//        }
//
//        // Validación: Verificar que no exista un equipamiento con el mismo nombre
//        if (equipamientoRepository.findByNombre(equipamiento.getNombre()).isPresent()) {
//            throw new IllegalArgumentException("El equipamiento con el nombre '" + equipamiento.getNombre() + "' ya existe.");
//        }
//
//        // Normalizar el nombre
//        equipamiento.setNombre(equipamiento.getNombre().trim().toLowerCase());
//
//        // Guardar en la base de datos
//        return equipamientoRepository.save(equipamiento);
//    }
//
//    // Metodo para listar todos los equipamientos en la base de datos
//    public List<Equipamiento> obtenerTodosEquipamientos() {
//        return equipamientoRepository.findAll();
//    }
//
//    // Metodo para actualizar un equipamiento existente
//    public Equipamiento actualizarEquipamiento(Long id, Equipamiento equipamientoActualizado) {
//        Equipamiento equipamientoExistente = equipamientoRepository.findById(id)
//            .orElseThrow(() -> new IllegalArgumentException("No se encontró el equipamiento con ID: " + id));
//
//        // Actualizar los campos necesarios
//        equipamientoExistente.setNombre(equipamientoActualizado.getNombre());
//        equipamientoExistente.setDescripcion(equipamientoActualizado.getDescripcion());
//        equipamientoExistente.setObjetivo(equipamientoActualizado.getObjetivo());
//
//        // Guardar los cambios
//        return equipamientoRepository.save(equipamientoExistente);
//    }
//
//    // Metodo para eliminar un equipamiento existente
//    public void eliminarEquipamiento(Long id) {
//        if (!equipamientoRepository.existsById(id)) {
//            throw new IllegalArgumentException("No se encontró el equipamiento con ID: " + id);
//        }
//        equipamientoRepository.deleteById(id);
//    }
//
//
//
//}