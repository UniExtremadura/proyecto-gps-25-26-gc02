package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ElementoInput
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-11-10T17:11:09.236506587Z[GMT]")

public class ElementoPut {

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("nombre")

  private String nombre = null;

  @JsonProperty("descripcion")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent
  private String descripcion = null;

  @JsonProperty("urlFoto")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent
  private String urlFoto = null;

  @JsonProperty("precio")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent
  private Float precio = null;

  @JsonProperty("esnovedad")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent
  private Boolean esnovedad = null;

  @JsonProperty("esalbum")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent
  private Boolean esalbum = null;

  @JsonProperty("genero")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent
  private Integer genero = null;

  @JsonProperty("subgenero")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent
  private Integer subgenero = null;

  @JsonProperty("artista")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent
  private Integer artista = null;

  @JsonProperty("numventas")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent
  private Integer numventas = null;

  @JsonProperty("valoracion")

  @JsonInclude(JsonInclude.Include.NON_ABSENT) // Exclude from JSON if absent
  private Integer valoracion = null;

  /**
   * Get id
   * 
   * @return id
   **/
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ElementoPut nombre(String nombre) {

    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * 
   * @return nombre
   **/

  @Schema(example = "Electric Dreams", required = true, description = "")

  @NotNull
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {

    this.nombre = nombre;
  }

  public ElementoPut descripcion(String descripcion) {

    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * 
   * @return descripcion
   **/

  @Schema(example = "Álbum debut de la banda SynthWave", description = "")

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public ElementoPut urlFoto(String urlFoto) {

    this.urlFoto = urlFoto;
    return this;
  }

  /**
   * url de la foto
   * 
   * @return urlFoto
   **/

  @Schema(example = "amazon", description = "url de la foto")

  public String getUrlFoto() {
    return urlFoto;
  }

  public void setUrlFoto(String urlFoto) {
    this.urlFoto = urlFoto;
  }

  public ElementoPut precio(Float precio) {

    this.precio = precio;
    return this;
  }

  /**
   * Get precio
   * 
   * @return precio
   **/

  @Schema(example = "19.99", description = "")

  public Float getPrecio() {
    return precio;
  }

  public void setPrecio(Float precio) {
    this.precio = precio;
  }

  public ElementoPut esnovedad(Boolean esnovedad) {

    this.esnovedad = esnovedad;
    return this;
  }

  /**
   * Get esnovedad
   * 
   * @return esnovedad
   **/

  @Schema(example = "true", description = "")

  public Boolean isEsnovedad() {
    return esnovedad;
  }

  public void setEsnovedad(Boolean esnovedad) {
    this.esnovedad = esnovedad;
  }

  public ElementoPut esalbum(Boolean esalbum) {

    this.esalbum = esalbum;
    return this;
  }

  /**
   * Get esalbum
   * 
   * @return esalbum
   **/

  @Schema(example = "false", description = "")

  public Boolean isEsalbum() {
    return esalbum;
  }

  public void setEsalbum(Boolean esalbum) {
    this.esalbum = esalbum;
  }

  public ElementoPut genero(Integer genero) {

    this.genero = genero;
    return this;
  }

  /**
   * Get genero
   * 
   * @return genero
   **/

  @Schema(example = "2", description = "")

  @Valid
  public Integer getGenero() {
    return genero;
  }

  public void setGenero(Integer genero) {
    this.genero = genero;
  }

  public ElementoPut subgenero(Integer subgenero) {

    this.subgenero = subgenero;
    return this;
  }

  /**
   * Get subgenero
   * 
   * @return subgenero
   **/

  @Schema(example = "3", description = "")

  @Valid
  public Integer getSubgenero() {
    return subgenero;
  }

  public void setSubgenero(Integer subgenero) {
    this.subgenero = subgenero;
  }

  public ElementoPut artista(Integer artista) {

    this.artista = artista;
    return this;
  }

  /**
   * Get artista
   * 
   * @return artista
   **/

  @Schema(example = "2", description = "")

  @Valid
  public Integer getArtista() {
    return artista;
  }

  public void setArtista(Integer artista) {
    this.artista = artista;
  }

  public ElementoPut numventas(Integer numventas) {

    this.numventas = numventas;
    return this;
  }

  /**
   * Get numventas
   * 
   * @return numventas
   **/

  @Schema(example = "120", description = "")

  public Integer getNumventas() {
    return numventas;
  }

  public void setNumventas(Integer numventas) {
    this.numventas = numventas;
  }

  public ElementoPut valoracion(Integer valoracion) {

    this.valoracion = valoracion;
    return this;
  }

  /**
   * Get valoracion
   * minimum: 0
   * maximum: 5
   * 
   * @return valoracion
   **/

  @Schema(example = "4", description = "")

  @Min(0)
  @Max(5)
  public Integer getValoracion() {
    return valoracion;
  }

  public void setValoracion(Integer valoracion) {
    this.valoracion = valoracion;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementoPut elementoInput = (ElementoPut) o;
    return Objects.equals(this.nombre, elementoInput.nombre) &&
        Objects.equals(this.descripcion, elementoInput.descripcion) &&
        Objects.equals(this.urlFoto, elementoInput.urlFoto) &&
        Objects.equals(this.precio, elementoInput.precio) &&
        Objects.equals(this.esnovedad, elementoInput.esnovedad) &&
        Objects.equals(this.esalbum, elementoInput.esalbum) &&
        Objects.equals(this.genero, elementoInput.genero) &&
        Objects.equals(this.subgenero, elementoInput.subgenero) &&
        Objects.equals(this.artista, elementoInput.artista);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, descripcion, urlFoto, precio, esnovedad, esalbum, genero, subgenero, artista);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElementoInput {\n");

    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    urlFoto: ").append(toIndentedString(urlFoto)).append("\n");
    sb.append("    precio: ").append(toIndentedString(precio)).append("\n");
    sb.append("    esnovedad: ").append(toIndentedString(esnovedad)).append("\n");
    sb.append("    esalbum: ").append(toIndentedString(esalbum)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    subgenero: ").append(toIndentedString(subgenero)).append("\n");
    sb.append("    artista: ").append(toIndentedString(artista)).append("\n");
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
