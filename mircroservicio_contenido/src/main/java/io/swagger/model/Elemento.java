package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Elemento
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")


public class Elemento   {
  @JsonProperty("id")

  private Integer id = null;

  @JsonProperty("nombre")

  private String nombre = null;

  @JsonProperty("fechacrea")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private OffsetDateTime fechacrea = null;

  @JsonProperty("descripcion")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String descripcion = null;

  @JsonProperty("urlFoto")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String urlFoto = null;

  @JsonProperty("numventas")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer numventas = null;

  @JsonProperty("valoracion")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer valoracion = null;

  @JsonProperty("precio")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Float precio = null;

  @JsonProperty("esnovedad")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Boolean esnovedad = null;

  @JsonProperty("esalbum")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Boolean esalbum = null;

  @JsonProperty("genero")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Genero genero = null;

  @JsonProperty("subgenero")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Genero subgenero = null;

  @JsonProperty("artista")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Artista artista = null;


  public Elemento id(Integer id) { 

    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  
  @Schema(example = "1", required = true, description = "")
  
  @NotNull
  public Integer getId() {  
    return id;
  }

  public void setId(Integer id) { 

    this.id = id;
  }

  public Elemento nombre(String nombre) { 

    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
   **/
  
  @Schema(example = "Álbum: Electric Dreams", required = true, description = "")
  
  @NotNull
  public String getNombre() {  
    return nombre;
  }

  public void setNombre(String nombre) { 

    this.nombre = nombre;
  }

  public Elemento fechacrea(OffsetDateTime fechacrea) { 

    this.fechacrea = fechacrea;
    return this;
  }

  /**
   * Get fechacrea
   * @return fechacrea
   **/
  
  @Schema(example = "2025-10-06T14:00Z", description = "")
  
@Valid
  public OffsetDateTime getFechacrea() {  
    return fechacrea;
  }

  public void setFechacrea(OffsetDateTime fechacrea) { 
    this.fechacrea = fechacrea;
  }

  public Elemento descripcion(String descripcion) { 

    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
   **/
  
  @Schema(example = "Álbum debut de la banda SynthWave", description = "")
  
  public String getDescripcion() {  
    return descripcion;
  }

  public void setDescripcion(String descripcion) { 
    this.descripcion = descripcion;
  }

  public Elemento urlFoto(String urlFoto) { 

    this.urlFoto = urlFoto;
    return this;
  }

  /**
   * url de la foto
   * @return urlFoto
   **/
  
  @Schema(example = "amazon", description = "url de la foto")
  
  public String getUrlFoto() {  
    return urlFoto;
  }

  public void setUrlFoto(String urlFoto) { 
    this.urlFoto = urlFoto;
  }

  public Elemento numventas(Integer numventas) { 

    this.numventas = numventas;
    return this;
  }

  /**
   * Get numventas
   * @return numventas
   **/
  
  @Schema(example = "120", description = "")
  
  public Integer getNumventas() {  
    return numventas;
  }

  public void setNumventas(Integer numventas) { 
    this.numventas = numventas;
  }

  public Elemento valoracion(Integer valoracion) { 

    this.valoracion = valoracion;
    return this;
  }

  /**
   * Get valoracion
   * minimum: 0
   * maximum: 5
   * @return valoracion
   **/
  
  @Schema(example = "4", description = "")
  
@Min(0) @Max(5)   public Integer getValoracion() {  
    return valoracion;
  }

  public void setValoracion(Integer valoracion) { 
    this.valoracion = valoracion;
  }

  public Elemento precio(Float precio) { 

    this.precio = precio;
    return this;
  }

  /**
   * Get precio
   * @return precio
   **/
  
  @Schema(example = "19.99", description = "")
  
  public Float getPrecio() {  
    return precio;
  }

  public void setPrecio(Float precio) { 
    this.precio = precio;
  }

  public Elemento esnovedad(Boolean esnovedad) { 

    this.esnovedad = esnovedad;
    return this;
  }

  /**
   * Get esnovedad
   * @return esnovedad
   **/
  
  @Schema(example = "true", description = "")
  
  public Boolean isEsnovedad() {  
    return esnovedad;
  }

  public void setEsnovedad(Boolean esnovedad) { 
    this.esnovedad = esnovedad;
  }

  public Elemento esalbum(Boolean esalbum) { 

    this.esalbum = esalbum;
    return this;
  }

  /**
   * Get esalbum
   * @return esalbum
   **/
  
  @Schema(example = "true", description = "")
  
  public Boolean isEsalbum() {  
    return esalbum;
  }

  public void setEsalbum(Boolean esalbum) { 
    this.esalbum = esalbum;
  }

  public Elemento genero(Genero genero) { 

    this.genero = genero;
    return this;
  }

  /**
   * Get genero
   * @return genero
   **/
  
  @Schema(description = "")
  
@Valid
  public Genero getGenero() {  
    return genero;
  }

  public void setGenero(Genero genero) { 
    this.genero = genero;
  }

  public Elemento artista(Artista artista) { 

    this.artista = artista;
    return this;
  }

  /**
   * Get artista
   * @return artista
   **/
  
  @Schema(description = "")
  
@Valid
  public Artista getArtista() {  
    return artista;
  }

  public void setArtista(Artista artista) { 
    this.artista = artista;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Elemento elemento = (Elemento) o;
    return Objects.equals(this.id, elemento.id) &&
        Objects.equals(this.nombre, elemento.nombre) &&
        Objects.equals(this.fechacrea, elemento.fechacrea) &&
        Objects.equals(this.descripcion, elemento.descripcion) &&
        Objects.equals(this.urlFoto, elemento.urlFoto) &&
        Objects.equals(this.numventas, elemento.numventas) &&
        Objects.equals(this.valoracion, elemento.valoracion) &&
        Objects.equals(this.precio, elemento.precio) &&
        Objects.equals(this.esnovedad, elemento.esnovedad) &&
        Objects.equals(this.esalbum, elemento.esalbum) &&
        Objects.equals(this.genero, elemento.genero) &&
        Objects.equals(this.artista, elemento.artista);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, fechacrea, descripcion, urlFoto, numventas, valoracion, precio, esnovedad, esalbum, genero, artista);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Elemento {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    fechacrea: ").append(toIndentedString(fechacrea)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    urlFoto: ").append(toIndentedString(urlFoto)).append("\n");
    sb.append("    numventas: ").append(toIndentedString(numventas)).append("\n");
    sb.append("    valoracion: ").append(toIndentedString(valoracion)).append("\n");
    sb.append("    precio: ").append(toIndentedString(precio)).append("\n");
    sb.append("    esnovedad: ").append(toIndentedString(esnovedad)).append("\n");
    sb.append("    esalbum: ").append(toIndentedString(esalbum)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
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

  public Genero getSubgenero() {
    return this.subgenero;
  }

  public void setSubgenero(Genero id2) {
    this.subgenero = id2;
  }
}
