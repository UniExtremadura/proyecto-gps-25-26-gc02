package io.swagger.controllers;
import io.swagger.api.*;
import io.swagger.entity.CancionEntity;
import io.swagger.entity.ElementoEntity;
import io.swagger.entity.GeneroEntity;
import io.swagger.model.Artista;
import io.swagger.model.Cancion;
import io.swagger.model.Genero;
import io.swagger.repository.GeneroRepository;
import io.swagger.services.ArtistaClient;
import io.swagger.services.CancionService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-11-10T17:11:09.236506587Z[GMT]")
@RestController
public class CancionesidCancionApiController implements CancionesidCancionApi {

    private static final Logger log = LoggerFactory.getLogger(CancionesidCancionApiController.class);

    private final ObjectMapper objectMapper;
    private final CancionService cancionService;
    private final ArtistaClient artistaClient;
    private final GeneroRepository generoRepository;
    private final HttpServletRequest request;

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

    @org.springframework.beans.factory.annotation.Autowired
    public CancionesidCancionApiController(ObjectMapper objectMapper, HttpServletRequest request, CancionService cancionService, ArtistaClient artistaClient, GeneroRepository generoRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.cancionService = cancionService;
        this.artistaClient = artistaClient;
        this.generoRepository = generoRepository;
    }

    @DeleteMapping("/canciones/{idCancion}")
    public ResponseEntity<Void> cancionesidCancionDelete(@Parameter(in = ParameterIn.PATH, description = "ID de la canción a eliminar.", required=true, schema=@Schema()) @PathVariable("idCancion") Integer idCancion) {
        cancionService.delete(idCancion);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/canciones/{idCancion}")
    public ResponseEntity<Cancion> cancionesidCancionGet(@Parameter(in = ParameterIn.PATH, description = "ID de la canción a consultar", required=true, schema=@Schema()) @PathVariable("idCancion") Integer idCancion) {
        // 1. Llama al servicio, que devuelve un Optional<CancionEntity>
        Optional<CancionEntity> opt = cancionService.getById(idCancion);
        // 2. Mapea el Optional<CancionEntity> a ResponseEntity<Cancion>
        return opt.map(e -> ResponseEntity.ok(convertToModel(e)))
               .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
