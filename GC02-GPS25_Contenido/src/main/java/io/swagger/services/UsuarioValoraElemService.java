package io.swagger.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import io.swagger.entity.UsuarioValoraElemEntity;
import io.swagger.entity.UsuarioValoraElemId;
import io.swagger.repository.UsuarioValoraElemRepository;

import io.swagger.entity.ElementoEntity;
import io.swagger.model.UsuarioValoraElem;

import io.swagger.repository.ElementoRepository;


@Service
public class UsuarioValoraElemService {
    @PersistenceContext
    private EntityManager entityManager;

    private final UsuarioValoraElemRepository usuarioValoraElemRepository;
    private final ElementoRepository elementoRepository;

    public UsuarioValoraElemService(UsuarioValoraElemRepository usuarioValoraElemRepository, ElementoRepository elementoRepository) {
        this.usuarioValoraElemRepository = usuarioValoraElemRepository;
        this.elementoRepository = elementoRepository;
    }

    // GET all
    public List<UsuarioValoraElemEntity> getAll() {
        return usuarioValoraElemRepository.findAll();
    }

    // GET espfecífico
    public Optional<UsuarioValoraElemEntity> getById(Integer idUser, Integer idElem) {
        UsuarioValoraElemId pk = new UsuarioValoraElemId(idUser, idElem);
        return usuarioValoraElemRepository.findById(pk);
    }

    // GET by idelem
    public List<UsuarioValoraElemEntity> getByIdelem(Integer idelem) {
        return usuarioValoraElemRepository.findById_IdElem(idelem);
    }

    public UsuarioValoraElemEntity create(UsuarioValoraElemEntity uve) {
        // 1. Guardar la valoración
        UsuarioValoraElemEntity saved = usuarioValoraElemRepository.save(uve);
       
        // 2. Conseguir todas las valoraciones del elemento
        List<UsuarioValoraElemEntity> valoraciones =
                usuarioValoraElemRepository.findById_IdElem(uve.getId().getIdElem());

        // 3. Calcular la media
        double media = valoraciones
                .stream()
                .mapToDouble(UsuarioValoraElemEntity::getValoracion)
                .average()
                .orElse(0.0);

        // 4. Guardar la media en elemento
        ElementoEntity elemento =
                elementoRepository.findById(uve.getId().getIdElem()).orElseThrow();
        int mediaEntero = (int) Math.round(media);
        elemento.setValoracion(mediaEntero);
        elementoRepository.save(elemento);

        return saved;
    }

    // DELETE
    public void delete(UsuarioValoraElemId pk) {
        usuarioValoraElemRepository.deleteById(pk);
    }

    public UsuarioValoraElem convertToInputModel(UsuarioValoraElemEntity entity) {
        UsuarioValoraElem uve = new UsuarioValoraElem();
        
        uve.setIduser(entity.getId().getIdUser());
        uve.setIdelem(entity.getId().getIdElem());
        uve.setValoracion(entity.getValoracion());
        return uve;
    }
}

