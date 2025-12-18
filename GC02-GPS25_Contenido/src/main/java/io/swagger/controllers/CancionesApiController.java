package io.swagger.controllers;

import io.swagger.api.CancionesApi;
import io.swagger.entity.CancionEntity;
import io.swagger.entity.ElementoEntity;
import io.swagger.model.Cancion;
import io.swagger.services.CancionService;
import io.swagger.services.ElementoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.model.CancionInput;
import io.swagger.model.CancionPut;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")
@RestController
public class CancionesApiController implements CancionesApi {

    private static final Logger log = LoggerFactory.getLogger(CancionesApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final CancionService cancionService;
    private final ElementoService elementoService;

    @org.springframework.beans.factory.annotation.Autowired
    public CancionesApiController(ObjectMapper objectMapper, HttpServletRequest request, CancionService cancionService,
            ElementoService elementoService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.cancionService = cancionService;
        this.elementoService = elementoService;
    }

    @GetMapping("/canciones/album/{idAlbum}")
    public ResponseEntity<List<Cancion>> cancionesAlbumIdAlbumGet(
            @Parameter(in = ParameterIn.PATH, description = "ID del álbum cuyas canciones se desean consultar", required = true, schema = @Schema()) @PathVariable("idAlbum") Integer idAlbum) {
        List<Cancion> canciones = cancionService.getAll()
                .stream()
                .filter(c -> c.getIdAlbum() != null && c.getIdAlbum().equals(idAlbum))
                .collect(Collectors.toList());

        if (canciones.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(canciones);
    }

    @GetMapping("/canciones/artista/{idArtista}")
    public ResponseEntity<List<Cancion>> cancionesArtistaIdArtistaGet(
            @Parameter(in = ParameterIn.PATH, description = "ID del artista cuyas canciones se desean consultar", required = true, schema = @Schema()) @PathVariable("idArtista") Integer idArtista) {
        List<Cancion> canciones = cancionService.getAll()
                .stream()
                .filter(c -> c.getArtista() != null && c.getArtista().getId().equals(idArtista))
                .collect(Collectors.toList());

        if (canciones.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(canciones);
    }

    @GetMapping("/canciones/genero/{idGenero}")
    public ResponseEntity<List<Cancion>> cancionesGeneroIdGeneroGet(
            @Parameter(in = ParameterIn.PATH, description = "ID del género cuyas canciones se desean consultar", required = true, schema = @Schema()) @PathVariable("idGenero") Integer idGenero) {
        List<Cancion> canciones = cancionService.getAll()
                .stream()
                .filter(c -> c.getGenero() != null && c.getGenero().getId().equals(idGenero))
                .collect(Collectors.toList());

        if (canciones.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(canciones);

    }

    @Override
    public ResponseEntity<List<Cancion>> cancionesGet(
            @Parameter(in = ParameterIn.QUERY, description = "ID del álbum al que pertenece la canción", schema = @Schema()) @Valid @RequestParam(value = "idAlbum", required = false) Integer idAlbum,
            @Parameter(in = ParameterIn.QUERY, description = "Nombre de la canción", schema = @Schema()) @Valid @RequestParam(value = "nombre", required = false) String nombre) {
        List<Cancion> canciones = cancionService.getAll();
        if (canciones.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(canciones);
    }

    @Override
    public ResponseEntity<Cancion> cancionesPost(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody CancionInput body) {
        // 1. Crear Elemento
        ElementoEntity elemento = new ElementoEntity();
        elemento.setNombre(body.getNombre());
        elemento.setDescripcion(body.getDescripcion());
        elemento.setPrecio(body.getPrecio());
        elemento.setNumventas(0);
        elemento.setValoracion(0);
        elemento.setEsnovedad(false);
        elemento.setEsalbum(false); // Es canción
        elemento.setArtista(body.getArtista());
        elemento.setGenero(body.getGenero());
        elemento.setSubgenero(body.getSubgenero());
        elemento.setUrlFoto(body.getUrlFoto());

        // Guardar elemento → genera ID
        elemento = elementoService.save(elemento);
        System.out.println("Elemento creado con ID: " + elemento.getId());

        // 2. Crear Canción con el mismo ID
        CancionEntity cancion = new CancionEntity();
        cancion.setElemento(elemento); // Relación
        cancion.setNombreAudio(body.getNombreAudio());
        cancion.setNumRep(0); // Inicialmente 0

        // Si tiene álbum
        if (body.getIdAlbum() != null) {
            ElementoEntity album = elementoService.getByIdOrThrow(body.getIdAlbum());
            cancion.setAlbum(album);
        } else {
            cancion.setAlbum(null);
        }

        // Guardar canción
        cancion = cancionService.save(cancion);

        // Convertir a modelo Swagger
        return ResponseEntity.status(HttpStatus.CREATED).body(cancionService.convertToInputModel(cancion));
    }

    @Override
    public ResponseEntity<Cancion> cancionesPut(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody CancionPut body) {
        Optional<ElementoEntity> opt = elementoService.getById(body.getIdElemento());
        if (opt.isEmpty())
            return ResponseEntity.notFound().build();

        Optional<CancionEntity> optCancion = cancionService.getById(body.getIdElemento());
        if (optCancion.isEmpty())
            return ResponseEntity.notFound().build();

        ElementoEntity entity = opt.get();
        CancionEntity cancionEntity = optCancion.get();

        if (body.getNombre() != null)
            entity.setNombre(body.getNombre());
        if (body.getDescripcion() != null)
            entity.setDescripcion(body.getDescripcion());
        if (body.getPrecio() != null)
            entity.setPrecio(body.getPrecio());
        if (body.isEsalbum() != null)
            entity.setEsalbum(body.isEsalbum());
        if (body.isEsnovedad() != null)
            entity.setEsnovedad(body.isEsnovedad());
        if (body.getValoracion() != null)
            entity.setValoracion(body.getValoracion());
        if (body.getNumventas() != null)
            entity.setNumventas(body.getNumventas());
        if (body.getUrlFoto() != null)
            entity.setUrlFoto(body.getUrlFoto());
        if (body.getGenero() != null)
            entity.setGenero(body.getGenero());
        if (body.getSubgenero() != null)
            entity.setSubgenero(body.getSubgenero());
        if (body.getArtista() != null)
            entity.setArtista(body.getArtista());

        if (body.getNombreAudio() != null)
            cancionEntity.setNombreAudio(body.getNombreAudio());
        if (body.getNumRep() != null)
            cancionEntity.setNumRep(body.getNumRep());
        if (body.getIdAlbum() != null) {
            ElementoEntity album = elementoService.getByIdOrThrow(body.getIdAlbum());
            cancionEntity.setAlbum(album);
        }

        ElementoEntity updated = elementoService.save(entity);
        CancionEntity updatedCancion = cancionService.save(cancionEntity);

        return ResponseEntity.ok(cancionService.convertToModel(updatedCancion));
    }
}
