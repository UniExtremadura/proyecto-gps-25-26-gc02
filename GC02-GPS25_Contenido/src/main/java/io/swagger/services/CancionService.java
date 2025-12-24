package io.swagger.services;

import io.swagger.entity.CancionEntity;
import io.swagger.entity.ElementoEntity;
import io.swagger.entity.GeneroEntity;
import io.swagger.model.Artista;
import io.swagger.model.Cancion;
import io.swagger.model.Genero;
import io.swagger.repository.CancionRepository;
import io.swagger.repository.GeneroRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CancionService {

    private final CancionRepository cancionRepository;
    private final ArtistaClient artistaClient;
    private final GeneroRepository generoRepository;

    public Cancion convertToModel(CancionEntity entity) {

        Cancion c = new Cancion();

        ElementoEntity e = entity.getElemento(); // Por @MapsId

        // Datos heredados de Elemento
        c.setId(e.getId());
        c.setNombre(e.getNombre());
        c.setDescripcion(e.getDescripcion());
        c.setPrecio(e.getPrecio());
        c.setNumventas(e.getNumventas());
        c.setValoracion(e.getValoracion());
        c.setEsnovedad(e.getEsnovedad());
        c.setUrlFoto(e.getUrlFoto());
        if (e.getArtista() != null) {
            Artista a = artistaClient.obtenerArtistaPorId(e.getArtista());
            c.setArtista(a);
        }
         // Género
        Genero g = new Genero();
        Integer idGenero = e.getGenero();

        if (idGenero != null) {
        GeneroEntity genero = generoRepository.findById(idGenero).orElse(null);
        if (genero != null) {
                g.setId(genero.getId());
                g.setNombre(genero.getNombre());
        } else {
                g.setId(idGenero);
                g.setNombre(null);
        }
        }
        c.setGenero(g);

        // Subgénero
        Genero sub = new Genero();
        Integer idSub = e.getSubgenero();

        if (idSub != null) {
        GeneroEntity subgenero = generoRepository.findById(idSub).orElse(null);
        if (subgenero != null) {
                sub.setId(subgenero.getId());
                sub.setNombre(subgenero.getNombre());
        } else {
                sub.setId(idSub);
                sub.setNombre(null);
        }
        }
        c.setSubgenero(sub);

        // Conversión fecha
        if (e.getFechacrea() != null) {
            org.threeten.bp.LocalDateTime fecha =
                    org.threeten.bp.LocalDateTime.of(
                            e.getFechacrea().getYear(),
                            e.getFechacrea().getMonthValue(),
                            e.getFechacrea().getDayOfMonth(),
                            e.getFechacrea().getHour(),
                            e.getFechacrea().getMinute(),
                            e.getFechacrea().getSecond()
                    );
            c.setFechacrea(fecha.atOffset(org.threeten.bp.ZoneOffset.UTC));
        }

        // Datos propios de Cancion
        c.setIdElemento(entity.getId());
        c.setNombreAudio(entity.getNombreAudio());
        c.setNumRep(entity.getNumRep());
        c.setIdAlbum(entity.getAlbum() != null ? entity.getAlbum().getId() : null);
        return c;
    }


    public CancionService(CancionRepository cancionRepository, ArtistaClient artistaClient, GeneroRepository generoRepository) {
        this.cancionRepository = cancionRepository;
        this.artistaClient = artistaClient;
        this.generoRepository = generoRepository;
    }

    public List<Cancion> getAll() {
        return cancionRepository.findAll()
                .stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }       

    public Optional<CancionEntity> getById(Integer id) {
        return cancionRepository.findById(id);
    }

    public CancionEntity save(CancionEntity elemento) {
        return cancionRepository.save(elemento);
    }

    public void delete(Integer id) {
        cancionRepository.deleteById(id);
    }


    public Cancion convertToInputModel(CancionEntity cancion) {
        Cancion c = new Cancion();

        ElementoEntity e = cancion.getElemento(); // Por @MapsId

        // Datos heredados de Elemento
        c.setId(e.getId());
        c.setNombre(e.getNombre());
        c.setDescripcion(e.getDescripcion());
        c.setPrecio(e.getPrecio());
        c.setNumventas(e.getNumventas());
        c.setValoracion(e.getValoracion());
        c.setEsnovedad(e.getEsnovedad());
        c.setUrlFoto(e.getUrlFoto());

        // Datos propios de Cancion
        c.setIdElemento(cancion.getId());
        c.setNombreAudio(cancion.getNombreAudio());
        c.setNumRep(cancion.getNumRep());
        c.setIdAlbum(cancion.getAlbum() != null ? cancion.getAlbum().getId() : null);
        return c;
    }
}

