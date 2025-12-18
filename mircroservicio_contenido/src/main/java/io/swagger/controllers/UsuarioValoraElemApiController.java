package io.swagger.controllers;

import io.swagger.api.UsuarioValoraElemApi;
import io.swagger.entity.ElementoEntity;
import io.swagger.entity.UsuarioValoraElemEntity;
import io.swagger.entity.UsuarioValoraElemId;
import io.swagger.model.Cancion;
import io.swagger.model.Elemento;
import io.swagger.model.Usuario;
import io.swagger.model.UsuarioValoraElem;
import io.swagger.repository.ElementoRepository;
import io.swagger.services.UsuarioValoraElemService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-11-19T10:28:12.285996221Z[GMT]")
@RestController
public class UsuarioValoraElemApiController implements UsuarioValoraElemApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    private final ElementoRepository elementoRepository;
    private final UsuarioValoraElemService usuarioValoraElemService;

    private UsuarioValoraElem converToModel(UsuarioValoraElemEntity entity) {
        UsuarioValoraElem uve = new UsuarioValoraElem();
        uve.setIduser(entity.getId().getIdUser());
        uve.setIdelem(entity.getId().getIdElem());
        uve.setValoracion(entity.getValoracion());
        uve.setComentario(entity.getComentario());
        uve.setFechaComentario(entity.getFechaComentario().toString());
        return uve;
    }

    @org.springframework.beans.factory.annotation.Autowired
    public UsuarioValoraElemApiController(ObjectMapper objectMapper, HttpServletRequest request, UsuarioValoraElemService usuarioValoraElemService, ElementoRepository elementoRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.usuarioValoraElemService = usuarioValoraElemService;
        this.elementoRepository = elementoRepository;
    }

    // GET /usuarioValoraElem
    @Override
    public ResponseEntity<List<UsuarioValoraElem>> usuarioValoraElemGet() {
       List<UsuarioValoraElemEntity> valoraciones = usuarioValoraElemService.getAll();
       List<UsuarioValoraElem> valoracionesModel = valoraciones.stream()
               .map(this::converToModel)
               .toList();
        if (valoraciones.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(valoracionesModel); 
    }

    // GET /usuarioValoraElem/{idUsuario}/{idElemento}
    @Override
    public ResponseEntity<Integer> usuarioValoraElemIdUsuarioIdElementoGet(@Parameter(in = ParameterIn.PATH, description = "ID del usuario", required=true, schema=@Schema()) @PathVariable("idUsuario") Integer idUsuario
        ,@Parameter(in = ParameterIn.PATH, description = "ID del elemento", required=true, schema=@Schema()) @PathVariable("idElemento") Integer idElemento) {
        UsuarioValoraElemEntity entity = usuarioValoraElemService.getById(idUsuario, idElemento).orElse(null);
        if(entity != null) {
            return ResponseEntity.ok(entity.getValoracion());
        }

        return ResponseEntity.notFound().build();
    }

    // GET /usuarioValoraElem/{idelemento}
    @Override
    public ResponseEntity<List<UsuarioValoraElem>> getComentariosElem(@Parameter(in = ParameterIn.PATH, description = "ID del elemento", required=true, schema=@Schema()) @PathVariable("idelemento") Integer idelemento) {
        List<UsuarioValoraElemEntity> valoraciones = usuarioValoraElemService.getByIdelem(idelemento);
        List<UsuarioValoraElem> valoracionesModel = valoraciones.stream()
                .map(this::converToModel)
                .toList();
         if (valoraciones.isEmpty())
             return ResponseEntity.noContent().build();
 
         return ResponseEntity.ok(valoracionesModel); 
    }

    // POST /usuarioValoraElem
    @Override
    public ResponseEntity<UsuarioValoraElem> usuarioValoraElemPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UsuarioValoraElem body) {
        UsuarioValoraElemEntity entity = new UsuarioValoraElemEntity();
        UsuarioValoraElemId pk = new UsuarioValoraElemId(body.getIduser(), body.getIdelem());
        ElementoEntity elemento = elementoRepository.findById(body.getIdelem()).orElse(null);
        
        entity.setElemento(elemento);
        entity.setId(pk);
        entity.setValoracion(body.getValoracion());
        entity.setComentario(body.getComentario());
        entity.setFechaComentario(java.time.LocalDateTime.now());
        UsuarioValoraElemEntity createdEntity = usuarioValoraElemService.create(entity);
        UsuarioValoraElem createdModel = converToModel(createdEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModel);
    }

    // PUT /usuarioValoraElem
    @Override
    public ResponseEntity<UsuarioValoraElem> usuarioValoraElemPut(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UsuarioValoraElem body) {
        Optional< UsuarioValoraElemEntity> existingEntityOpt = usuarioValoraElemService.getById(body.getIduser(), body.getIdelem());
        if (existingEntityOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        UsuarioValoraElemEntity entity = existingEntityOpt.get();
        UsuarioValoraElemId pk = new UsuarioValoraElemId(body.getIduser(), body.getIdelem());
        ElementoEntity elemento = elementoRepository.findById(body.getIdelem()).orElse(null);
        
        entity.setElemento(elemento);
        entity.setId(pk);
        
        if(body.getValoracion() != null) {
            entity.setValoracion(body.getValoracion());
        }
        if(body.getComentario() != null) {
            entity.setComentario(body.getComentario());
        }
        entity.setFechaComentario(java.time.LocalDateTime.now());
        UsuarioValoraElemEntity createdEntity = usuarioValoraElemService.create(entity);
        UsuarioValoraElem createdModel = converToModel(createdEntity);
        return ResponseEntity.ok(createdModel);
    }

    // DELETE /usuarioValoraElem/{idUsuario}/{idElemento}
    @Override
    public ResponseEntity<Void> usuarioValoraElemIdUsuarioIdElementoDelete(@Parameter(in = ParameterIn.PATH, description = "ID del usuario", required=true, schema=@Schema()) @PathVariable("idUsuario") Integer idUsuario
,@Parameter(in = ParameterIn.PATH, description = "ID del elemento", required=true, schema=@Schema()) @PathVariable("idElemento") Integer idElemento) {
        UsuarioValoraElemId pk = new UsuarioValoraElemId(idUsuario, idElemento);
        if (!usuarioValoraElemService.getById(idUsuario, idElemento).isPresent()) {
            return ResponseEntity.notFound().build();
        } 
        else {
            usuarioValoraElemService.delete(pk);
            return ResponseEntity.noContent().build();
        }
    }

}
