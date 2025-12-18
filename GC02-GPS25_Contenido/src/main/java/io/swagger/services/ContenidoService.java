package io.swagger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import io.swagger.entity.ElementoEntity;
import io.swagger.entity.GeneroEntity;
import io.swagger.model.Contenido;
import io.swagger.model.Genero;
import io.swagger.repository.ElementoRepository;
import io.swagger.repository.GeneroRepository;

@Service
public class ContenidoService {

    @Autowired
    private ElementoRepository elementoRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private ArtistaClient artistaClient;

    /**
     * Convierte ElementoEntity → Contenido
     */
    private Contenido convertToContenido(ElementoEntity e) {
        Contenido c = new Contenido();

        c.setId(e.getId());
        c.setNombre(e.getNombre());
        c.setDescripcion(e.getDescripcion());
        c.setPrecio(e.getPrecio());
        c.setNumventas(e.getNumventas());
        c.setValoracion(e.getValoracion());
        c.setEsnovedad(e.getEsnovedad());
        c.setFotoamazon(e.getUrlFoto());

        // Convertimos fecha
        if (e.getFechacrea() != null) {
            org.threeten.bp.LocalDateTime fechaThreeTen =
                    org.threeten.bp.LocalDateTime.of(
                            e.getFechacrea().getYear(),
                            e.getFechacrea().getMonthValue(),
                            e.getFechacrea().getDayOfMonth(),
                            e.getFechacrea().getHour(),
                            e.getFechacrea().getMinute(),
                            e.getFechacrea().getSecond()
                    );

            c.setFechacrea( fechaThreeTen.atOffset(org.threeten.bp.ZoneOffset.UTC) );
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


        // Asignar tipo desde esalbum
        if (e.getEsalbum() != null && e.getEsalbum()) {
            c.setTipo(1); // Álbum
        } else {
            c.setTipo(2); // Canción
        }

        return c;
    }

    public List<Contenido> obtenerContenidoUnificado(
            Integer genero,
            Integer subgenero,
            Float preciomin,
            Float preciomax,
            org.threeten.bp.LocalDate fechamin,
            org.threeten.bp.LocalDate fechamax
    ) {

        // 1. Obtener todos los elementos internos
        List<ElementoEntity> entidades = elementoRepository.findAll();

        // 2. Convertir ElementoEntity → Contenido + aplicar filtros
        List<Contenido> internos = entidades.stream()
                .map(this::convertToContenido)
                .filter(c -> genero == null || 
                        (c.getGenero() != null && c.getGenero().getId().equals(genero)))
                .filter(c -> subgenero == null || 
                        (c.getSubgenero() != null && c.getSubgenero().getId().equals(subgenero)))
                .filter(c -> preciomin == null || 
                        (c.getPrecio() != null && c.getPrecio() >= preciomin))
                .filter(c -> preciomax == null || 
                        (c.getPrecio() != null && c.getPrecio() <= preciomax))
                .filter(c -> {
                    if (fechamin == null && fechamax == null) return true;
                    if (c.getFechacrea() == null) return false;

                    org.threeten.bp.LocalDate fecha = c.getFechacrea().toLocalDate();

                    if (fechamin != null && fecha.isBefore(fechamin)) return false;
                    if (fechamax != null && fecha.isAfter(fechamax)) return false;

                    return true;
                })
                .collect(Collectors.toList());

        // 3. Obtener los artistas externos (ya convertidos a Contenido)
        List<Contenido> artistas = artistaClient.obtenerArtistas();

        // 4. Merge final
        List<Contenido> resultado = new ArrayList<>();
        resultado.addAll(artistas);   // tipo = 0
        resultado.addAll(internos);   // tipo = 1 ó 2

        return resultado;
    }
}
