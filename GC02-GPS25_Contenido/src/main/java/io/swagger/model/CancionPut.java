package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.constraints.*;

/**
 * CancionPut
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-11-10T17:11:09.236506587Z[GMT]")

public class CancionPut extends ElementoPut {
  @JsonProperty("idElemento")

  private Integer idElemento = null;

  @JsonProperty("nombreAudio")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent

  private String nombreAudio = null;

  @JsonProperty("numRep")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent
  private Integer numRep = null;

  @JsonProperty("idAlbum")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent

  private Integer idAlbum = null;

  public CancionPut idElemento(Integer idElemento) {

    this.idElemento = idElemento;
    return this;
  }

  /**
   * Identificador único de la canción.
   * 
   * @return idElemento
   **/

  @Schema(example = "3", required = true, description = "Identificador único de la canción.")

  @NotNull
  public Integer getIdElemento() {
    return idElemento;
  }

  public void setIdElemento(Integer idElemento) {

    this.idElemento = idElemento;
  }

  public CancionPut nombreAudio(String nombreAudio) {

    this.nombreAudio = nombreAudio;
    return this;
  }

  /**
   * Nombre del archivo de audio.
   * 
   * @return nombreAudio
   **/

  @Schema(example = "ForeverYoung", description = "Nombre del archivo de audio.")

  @Size(max = 100)
  public String getNombreAudio() {
    return nombreAudio;
  }

  public void setNombreAudio(String nombreAudio) {
    this.nombreAudio = nombreAudio;
  }

  public CancionPut numRep(Integer numRep) {

    this.numRep = numRep;
    return this;
  }

  /**
   * Número de reproducciones de la canción.
   * minimum: 0
   * 
   * @return numRep
   **/

  @Schema(example = "15420", description = "Número de reproducciones de la canción.")

  @Min(0)
  public Integer getNumRep() {
    return numRep;
  }

  public void setNumRep(Integer numRep) {
    this.numRep = numRep;
  }

  public CancionPut idAlbum(Integer idAlbum) {

    this.idAlbum = idAlbum;
    return this;
  }

  /**
   * Identificador del álbum al que pertenece la canción (si aplica).
   * 
   * @return idAlbum
   **/

  @Schema(example = "5", description = "Identificador del álbum al que pertenece la canción (si aplica).")

  public Integer getIdAlbum() {
    return idAlbum;
  }

  public void setIdAlbum(Integer idAlbum) {
    this.idAlbum = idAlbum;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CancionPut cancion = (CancionPut) o;
    return Objects.equals(this.idElemento, cancion.idElemento) &&
        Objects.equals(this.nombreAudio, cancion.nombreAudio) &&
        Objects.equals(this.numRep, cancion.numRep) &&
        Objects.equals(this.idAlbum, cancion.idAlbum) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idElemento, nombreAudio, numRep, idAlbum, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cancion {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    idElemento: ").append(toIndentedString(idElemento)).append("\n");
    sb.append("    nombreAudio: ").append(toIndentedString(nombreAudio)).append("\n");
    sb.append("    numRep: ").append(toIndentedString(numRep)).append("\n");
    sb.append("    idAlbum: ").append(toIndentedString(idAlbum)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
