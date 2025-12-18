package io.swagger.services;

import io.swagger.entity.ElementoEntity;
import io.swagger.repository.ElementoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementoService {

    private final ElementoRepository elementoRepository;

    public ElementoService(ElementoRepository elementoRepository) {
        this.elementoRepository = elementoRepository;
    }

    public List<ElementoEntity> getAll() {
        return elementoRepository.findAll();
    }

    public Optional<ElementoEntity> getById(Integer id) {
        return elementoRepository.findById(id);
    }

    public ElementoEntity getByIdOrThrow(Integer id) {
        return elementoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Elemento no encontrado: " + id));
    }

    public ElementoEntity save(ElementoEntity elemento) {
        return elementoRepository.save(elemento);
    }

    public void delete(Integer id) {
        elementoRepository.deleteById(id);
    }
}

