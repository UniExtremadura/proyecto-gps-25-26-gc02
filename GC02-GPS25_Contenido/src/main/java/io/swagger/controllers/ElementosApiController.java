package io.swagger.controllers;

import io.swagger.api.ElementosApi;
import io.swagger.entity.ElementoEntity;
import io.swagger.entity.GeneroEntity;
import io.swagger.model.*;
import io.swagger.repository.GeneroRepository;
import io.swagger.services.ArtistaClient;
import io.swagger.services.ElementoService;
import java.util.Optional;

import org.threeten.bp.LocalDate;
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

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")
@RestController
public class ElementosApiController implements ElementosApi {

    private static final Logger log = LoggerFactory.getLogger(ElementosApiController.class);
    private final ElementoService elementoService;
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final GeneroRepository generoRepository;
    private final ArtistaClient artistaClient;

    private Elemento convertToModel(ElementoEntity entity) {
        Elemento e = new Elemento();
        e.setId(entity.getId());
        e.setNombre(entity.getNombre());
        e.setDescripcion(entity.getDescripcion());
        e.setPrecio(entity.getPrecio());
        e.setEsalbum(entity.getEsalbum());
        e.setEsnovedad(entity.getEsnovedad());
        // --- AÑADE ESTO ---
        if (entity.getFechacrea() != null) {
            // 1. Obtenemos la fecha original (java.time)
            java.time.LocalDateTime fechaDb = entity.getFechacrea();

            // 2. Construimos la fecha compatible con Swagger (org.threeten.bp)
            // Copiamos año, mes, día, hora, minuto y segundo.
            org.threeten.bp.LocalDateTime fechaCompatible = org.threeten.bp.LocalDateTime.of(
                    fechaDb.getYear(),
                    fechaDb.getMonthValue(),
                    fechaDb.getDayOfMonth(),
                    fechaDb.getHour(),
                    fechaDb.getMinute(),
                    fechaDb.getSecond());

            // 3. Le asignamos una zona horaria (UTC) para convertirlo en OffsetDateTime
            e.setFechacrea(org.threeten.bp.OffsetDateTime.of(fechaCompatible, org.threeten.bp.ZoneOffset.UTC));
        }
        e.setValoracion(entity.getValoracion());
        e.setNumventas(entity.getNumventas());
        e.setUrlFoto(entity.getUrlFoto());
        // Género
        Genero g = new Genero();
        Integer idGenero = entity.getGenero();

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
        e.setGenero(g);

        // Subgénero
        Genero sub = new Genero();
        Integer idSub = entity.getSubgenero();

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
        e.setSubgenero(sub);
        // Artista
        if (entity.getArtista() != null) {
            Artista a = artistaClient.obtenerArtistaPorId(entity.getArtista());
            e.setArtista(a);
        }
        return e;
    }

    @org.springframework.beans.factory.annotation.Autowired
    public ElementosApiController(ElementoService elementoService, ObjectMapper objectMapper,
            HttpServletRequest request, GeneroRepository generoRepository) {
        this.elementoService = elementoService;
        this.objectMapper = objectMapper;
        this.request = request;
        this.generoRepository = generoRepository;
        this.artistaClient = new ArtistaClient();
    }

    // GET /elementos
    @Override
    public ResponseEntity<List<Elemento>> elementosGet(
            @Parameter(in = ParameterIn.QUERY, description = "ID del género por el que se desea filtrar.", schema = @Schema()) @Valid @RequestParam(value = "genero", required = false) Integer genero,
            @Parameter(in = ParameterIn.QUERY, description = "ID del subgénero por el que se desea filtrar.", schema = @Schema()) @Valid @RequestParam(value = "subgenero", required = false) Integer subgenero,
            @Parameter(in = ParameterIn.QUERY, description = "Precio mínimo del contenido.", schema = @Schema()) @Valid @RequestParam(value = "preciomin", required = false) Float preciomin,
            @Parameter(in = ParameterIn.QUERY, description = "Precio máximo del contenido.", schema = @Schema()) @Valid @RequestParam(value = "preciomax", required = false) Float preciomax,
            @Parameter(in = ParameterIn.QUERY, description = "Fecha mínima de creación o publicación.", schema = @Schema()) @Valid @RequestParam(value = "fechamin", required = false) LocalDate fechamin,
            @Parameter(in = ParameterIn.QUERY, description = "Fecha máxima de creación o publicación.", schema = @Schema()) @Valid @RequestParam(value = "fechamax", required = false) LocalDate fechamax) {

        List<ElementoEntity> entidades = elementoService.getAll();
        List<Elemento> elementos = entidades.stream()
                .filter(e -> preciomin == null || e.getPrecio() >= preciomin)
                .filter(e -> preciomax == null || e.getPrecio() <= preciomax)
                .filter(e -> genero == null || e.getGenero().equals(genero))
                .map(this::convertToModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(elementos);
    }

    @GetMapping("/elementos/artista/{idArtista}")
    public ResponseEntity<List<Elemento>> elementosArtistaIdArtistaGet(
            @Parameter(in = ParameterIn.PATH, description = "ID del artista cuyas elementos se desean consultar", required = true, schema = @Schema()) @PathVariable("idArtista") Integer idArtista) {
        List<Elemento> elementos = elementoService.getAll()
                .stream()
                .filter(c -> c.getArtista() != null && c.getArtista().equals(idArtista))
                .map(this::convertToModel)
                .collect(Collectors.toList());

        if (elementos.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(elementos);
    }

    @GetMapping("/elementos/genero/{idGenero}")
    public ResponseEntity<List<Elemento>> elementosGeneroIdGeneroGet(
            @Parameter(in = ParameterIn.PATH, description = "ID del género cuyas elementos se desean consultar", required = true, schema = @Schema()) @PathVariable("idGenero") Integer idGenero) {
        List<Elemento> elementos = elementoService.getAll()
                .stream()
                .filter(c -> c.getGenero() != null && c.getGenero().equals(idGenero))
                .map(this::convertToModel)
                .collect(Collectors.toList());

        if (elementos.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(elementos);

    }

    // DELETE /elementos/{id}
    @Override
    public ResponseEntity<Void> elementosIdDelete(
            @Parameter(in = ParameterIn.PATH, description = "ID del contenido que se desea eliminar", required = true, schema = @Schema()) @PathVariable("id") Integer id) {
        elementoService.delete(id);
        return ResponseEntity.noContent().build();

    }

    // GET /elementos/{id}
    @Override
    public ResponseEntity<Elemento> elementosIdGet(
            @Parameter(in = ParameterIn.PATH, description = "ID del contenido a consultar", required = true, schema = @Schema()) @PathVariable("id") Integer id) {
        Optional<ElementoEntity> opt = elementoService.getById(id);
        return opt.map(e -> ResponseEntity.ok(convertToModel(e)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /elementos
    @Override
    public ResponseEntity<Elemento> elementosPost(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody ElementoInput body) {
        ElementoEntity entity = new ElementoEntity();
        entity.setNombre(body.getNombre());
        entity.setArtista(body.getArtista());
        entity.setDescripcion(body.getDescripcion());
        entity.setPrecio(body.getPrecio());
        entity.setEsalbum(body.isEsalbum());
        entity.setEsnovedad(true);
        entity.setValoracion(0);
        entity.setNumventas(0);
        entity.setGenero(body.getGenero());
        entity.setSubgenero(body.getSubgenero());
        entity.setUrlFoto(body.getUrlFoto());

        ElementoEntity saved = elementoService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToModel(saved));
    }

    // PUT /elementos
    @Override
    public ResponseEntity<Elemento> elementosPut(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody ElementoPut body) {
        Optional<ElementoEntity> opt = elementoService.getById(body.getId());
        if (opt.isEmpty())
            return ResponseEntity.notFound().build();

        ElementoEntity entity = opt.get();
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

        ElementoEntity updated = elementoService.save(entity);
        return ResponseEntity.ok(convertToModel(updated));

    }

}
