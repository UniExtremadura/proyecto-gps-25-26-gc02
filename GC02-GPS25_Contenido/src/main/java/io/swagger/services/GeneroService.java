package io.swagger.services;

import io.swagger.entity.GeneroEntity;
import io.swagger.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<GeneroEntity> getAllGeneros() {
        return generoRepository.findAll();
    }

    public Optional<GeneroEntity> getGeneroById(Integer id) {
        return generoRepository.findById(id);
    }

    public GeneroEntity createGenero(GeneroEntity genero) {
        return generoRepository.save(genero);
    }

    public GeneroEntity updateGenero(Integer id, GeneroEntity generoDetails) {
        return generoRepository.findById(id)
                .map(genero -> {
                    genero.setNombre(generoDetails.getNombre());
                    return generoRepository.save(genero);
                })
                .orElse(null);
    }

    public void deleteGenero(Integer id) {
        generoRepository.deleteById(id);
    }
}
