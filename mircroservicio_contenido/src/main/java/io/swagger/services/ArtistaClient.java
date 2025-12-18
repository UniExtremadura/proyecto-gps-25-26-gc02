package io.swagger.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.threeten.bp.OffsetDateTime;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import io.swagger.model.Contenido;
import io.swagger.model.Genero;
import io.swagger.model.Artista;

@Service
public class ArtistaClient {

    // IMPORTANTE: Asegúrate de que este puerto (3000) es donde corre tu backend de
    // usuarios.
    // Si usas otro puerto (ej. 8080), cámbialo aquí.
    private String usuariosBaseUrl = "http://localhost:3000/api/usuarios";

    private final RestTemplate restTemplate = new RestTemplate();

    // Obtener la lista de artistas desde el microservicio externo para mapear a
    // Contenido
    public List<Contenido> obtenerArtistas() {

        String url = usuariosBaseUrl + "/artistas";

        // Usamos ParameterizedTypeReference para asegurar que recibimos una Lista de
        // Mapas
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {
                });

        List<Map<String, Object>> artistasJson = response.getBody();
        List<Contenido> artistas = new ArrayList<>();

        if (artistasJson == null) {
            return artistas;
        }

        for (Map<String, Object> art : artistasJson) {
            try {
                Contenido c = new Contenido();

                // --- FIX 1: Casteo seguro de IDs numéricos ---
                Object idObj = art.get("id");
                if (idObj instanceof Number) {
                    c.setId(((Number) idObj).intValue());
                }

                c.setNombre((String) art.get("nombreusuario"));

                // --- FIX 2: Parseo de fecha seguro ---
                Object fechaObjeto = art.get("fecharegistro");
                if (fechaObjeto instanceof String) {
                    try {
                        OffsetDateTime fecha = OffsetDateTime.parse((String) fechaObjeto);
                        c.setFechacrea(fecha);
                    } catch (DateTimeParseException e) {
                        System.err.println("Error parseando fecha para artista ID " + idObj + ": " + fechaObjeto);
                    }
                }

                c.setDescripcion((String) art.get("descripcion"));

                // --- FIX 3: Valoración y Ventas (Manejo de Double a Integer) ---
                // Si la valoración viene como 3.8 (Double), el cast directo a (Integer)
                // fallaba.
                Object oyentesObj = art.getOrDefault("oyentes", 0);
                if (oyentesObj instanceof Number) {
                    c.setNumventas(((Number) oyentesObj).intValue());
                }

                Object valObj = art.getOrDefault("valoracion", 0);
                if (valObj instanceof Number) {
                    // Convertimos cualquier número (Double, Float) a int de forma segura
                    c.setValoracion(((Number) valObj).intValue());
                }

                c.setPrecio(0.0f); // Artistas no tienen precio

                // Booleano seguro
                Object esNovedadObj = art.get("esnovedad");
                c.setEsnovedad(esNovedadObj instanceof Boolean ? (Boolean) esNovedadObj : false);

                c.setFotoamazon((String) art.get("rutafoto"));

                // --- FIX 4: GÉNERO (El error principal) ---
                // El JSON suele traer un objeto: "genero": { "id": 1, ... }
                // El código antiguo intentaba leerlo como Integer directamente y fallaba.
                Genero g = new Genero();
                Object generoObj = art.get("genero");

                if (generoObj instanceof Map) {
                    // Caso A: Es un objeto JSON (LinkedHashMap)
                    Map<?, ?> generoMap = (Map<?, ?>) generoObj;
                    Object idGenero = generoMap.get("id");
                    if (idGenero instanceof Number) {
                        g.setId(((Number) idGenero).intValue());
                    }
                    // Meter genero en el artista
                    Object nombreGen = generoMap.get("nombre");
                    if (nombreGen instanceof String) {
                        g.setNombre((String) nombreGen);
                    }

                } else if (generoObj instanceof Number) {
                    // Caso B: Es solo el número ID
                    g.setId(((Number) generoObj).intValue());
                }

                c.setGenero(g);
                c.setTipo(0); // 0 = artista
                artistas.add(c);

            } catch (Exception e) {
                // Si falla un artista concreto, lo logueamos y seguimos con el siguiente
                System.err.println("Error mapeando un artista: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return artistas;
    }

    public Artista obtenerArtistaPorId(Integer idArtista) {
        String url = usuariosBaseUrl + "/artistas/" + idArtista;

        ResponseEntity<Artista> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                Artista.class);

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new RuntimeException("No se ha podido obtener el artista con id " + idArtista);
        }

        return response.getBody();
    }
}