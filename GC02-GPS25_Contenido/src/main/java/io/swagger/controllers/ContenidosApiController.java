package io.swagger.controllers;

import io.swagger.api.ContenidosApi;
import io.swagger.model.Contenido;

import io.swagger.services.ContenidoService;
import io.swagger.services.ElementoService;
import org.threeten.bp.LocalDate;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")
@RestController
public class ContenidosApiController implements ContenidosApi {

    private static final Logger log = LoggerFactory.getLogger(ContenidosApiController.class);
    private final ElementoService elementoService;
      private final ContenidoService contenidoService;
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ContenidosApiController(ElementoService elementoService, ContenidoService contenidoService,ObjectMapper objectMapper, HttpServletRequest request) {
        this.elementoService = elementoService;
        this.contenidoService = contenidoService;
        this.objectMapper = objectMapper;
        this.request = request;
    }

    // localhost:8080/api/contenidos    
    public ResponseEntity<List<Contenido>> contenidosGet(@Parameter(in = ParameterIn.QUERY, description = "ID del género por el que se desea filtrar." ,schema=@Schema()) @Valid @RequestParam(value = "genero", required = false) Integer genero
,@Parameter(in = ParameterIn.QUERY, description = "ID del subgénero por el que se desea filtrar." ,schema=@Schema()) @Valid @RequestParam(value = "subgenero", required = false) Integer subgenero
,@Parameter(in = ParameterIn.QUERY, description = "Precio mínimo del contenido." ,schema=@Schema()) @Valid @RequestParam(value = "preciomin", required = false) Float preciomin
,@Parameter(in = ParameterIn.QUERY, description = "Precio máximo del contenido." ,schema=@Schema()) @Valid @RequestParam(value = "preciomax", required = false) Float preciomax
,@Parameter(in = ParameterIn.QUERY, description = "Fecha mínima de creación o publicación." ,schema=@Schema()) @Valid @RequestParam(value = "fechamin", required = false) LocalDate fechamin
,@Parameter(in = ParameterIn.QUERY, description = "Fecha máxima de creación o publicación." ,schema=@Schema()) @Valid @RequestParam(value = "fechamax", required = false) LocalDate fechamax) {
        List<Contenido> lista = contenidoService.obtenerContenidoUnificado(
            genero, subgenero, preciomin, preciomax, fechamin, fechamax);

        return ResponseEntity.ok(lista);
    }

}
