package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import io.swagger.configuration.NotUndefined;
import javax.validation.constraints.*;

/**
 * UsuarioValoraElem
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")

public class UsuarioValoraElem {
    @JsonProperty("idelem")
    @NotNull
    private Integer idelem = null;

    @JsonProperty("iduser")
    @NotNull
    private Integer iduser = null;

    @JsonProperty("valoracion")
    @NotNull
    private Integer valoracion = null;

    @JsonProperty("comentario")
    private String comentario = null;

    @JsonProperty("fechaComentario")
    private String fechaComentario = null;

    public UsuarioValoraElem idelem(Integer idelem) {
        this.idelem = idelem;
        return this;
    }

    /**
     * Identificador del elemento valorado
     * @return idelem
     **/
    @Schema(example = "5", required = true, description = "Identificador del elemento valorado")
    @NotNull
    public Integer getIdelem() {
        return idelem;
    }
    public void setIdelem(Integer idelem) {
        this.idelem = idelem;
    }
    public UsuarioValoraElem iduser(Integer iduser) {
        this.iduser = iduser;
        return this;
    }
    /**
     * Identificador del usuario que valora el elemento
     * @return iduser
     **/
    @Schema(example = "10", required = true, description = "Identificador del usuario que valora el elemento")
    @NotNull
    public Integer getIduser() {
        return iduser;
    }
    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }
    public UsuarioValoraElem valoracion(Integer valoracion) {
        this.valoracion = valoracion;
        return this;
    }
    /**
     * Valoración dada por el usuario al elemento (1-5)
     * @return valoracion
     **/
    @Schema(example = "4", required = true, description = "Valoración dada por el usuario al elemento (1-5)")
    @NotNull
    public Integer getValoracion() {
        return valoracion;
    }
    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public String getFechaComentario() {
        return fechaComentario;
    }
    public void setFechaComentario(String fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UsuarioValoraElem usuarioValoraElem = (UsuarioValoraElem) o;
        return Objects.equals(this.idelem, usuarioValoraElem.idelem) &&
            Objects.equals(this.iduser, usuarioValoraElem.iduser) &&
            Objects.equals(this.valoracion, usuarioValoraElem.valoracion);
    }
    @Override
    public int hashCode() {
        return Objects.hash(idelem, iduser, valoracion);
    }
}