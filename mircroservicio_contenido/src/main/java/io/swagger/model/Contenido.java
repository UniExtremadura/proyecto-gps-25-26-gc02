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
 * Contenido
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")


public class Contenido   {
  @JsonProperty("id")

  private Integer id = null;

  @JsonProperty("nombre")

  private String nombre = null;

  @JsonProperty("fechacrea")

  private OffsetDateTime fechacrea = null;

  @JsonProperty("descripcion")

  private String descripcion = null;

  @JsonProperty("numventas")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer numventas = null;

  @JsonProperty("valoracion")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer valoracion = null;

  @JsonProperty("precio")

  private Float precio = null;

  @JsonProperty("esnovedad")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Boolean esnovedad = null;

  @JsonProperty("genero")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Genero genero = null;

  @JsonProperty("subgenero")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Genero subgenero = null;

  @JsonProperty("fotoamazon")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String fotoamazon = null;

  @JsonProperty("tipo")

  private Integer tipo = null;


  public Contenido id(Integer id) { 

    this.id = id;
    return this;
  }

  /**
   * Identificador único del contenido.
   * @return id
   **/
  
  @Schema(example = "1", required = true, description = "Identificador único del contenido.")
  
  @NotNull
  public Integer getId() {  
    return id;
  }



  public void setId(Integer id) { 

    this.id = id;
  }

  public Contenido nombre(String nombre) { 

    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre del contenido.
   * @return nombre
   **/
  
  @Schema(example = "Electric Dreams", required = true, description = "Nombre del contenido.")
  
  @NotNull
  public String getNombre() {  
    return nombre;
  }



  public void setNombre(String nombre) { 

    this.nombre = nombre;
  }

  public Contenido fechacrea(OffsetDateTime fechacrea) { 

    this.fechacrea = fechacrea;
    return this;
  }

  /**
   * Fecha de creación del contenido.
   * @return fechacrea
   **/
  
  @Schema(example = "2025-10-06T14:00Z", required = true, description = "Fecha de creación del contenido.")
  
@Valid
  @NotNull
  public OffsetDateTime getFechacrea() {  
    return fechacrea;
  }



  public void setFechacrea(OffsetDateTime fechacrea) { 

    this.fechacrea = fechacrea;
  }

  public Contenido descripcion(String descripcion) { 

    this.descripcion = descripcion;
    return this;
  }

  /**
   * Descripción del contenido.
   * @return descripcion
   **/
  
  @Schema(example = "Álbum debut de la banda SynthWave.", required = true, description = "Descripción del contenido.")
  
  @NotNull
  public String getDescripcion() {  
    return descripcion;
  }



  public void setDescripcion(String descripcion) { 

    this.descripcion = descripcion;
  }

  public Contenido numventas(Integer numventas) { 

    this.numventas = numventas;
    return this;
  }

  /**
   * Número de ventas del contenido.
   * @return numventas
   **/
  
  @Schema(example = "120", description = "Número de ventas del contenido.")
  
  public Integer getNumventas() {  
    return numventas;
  }



  public void setNumventas(Integer numventas) { 
    this.numventas = numventas;
  }

  public Contenido valoracion(Integer valoracion) { 

    this.valoracion = valoracion;
    return this;
  }

  /**
   * Valoración media del contenido.
   * minimum: 0
   * maximum: 5
   * @return valoracion
   **/
  
  @Schema(example = "4", description = "Valoración media del contenido.")
  
@Min(0) @Max(5)   public Integer getValoracion() {  
    return valoracion;
  }



  public void setValoracion(Integer valoracion) { 
    this.valoracion = valoracion;
  }

  public Contenido precio(Float precio) { 

    this.precio = precio;
    return this;
  }

  /**
   * Precio del contenido. Si es artista será null.
   * @return precio
   **/
  
  @Schema(example = "19.99", required = true, description = "Precio del contenido. Si es artista será null.")
  
  @NotNull
  public Float getPrecio() {  
    return precio;
  }



  public void setPrecio(Float precio) { 

    this.precio = precio;
  }

  public Contenido esnovedad(Boolean esnovedad) { 

    this.esnovedad = esnovedad;
    return this;
  }

  /**
   * Indica si el contenido es una novedad.
   * @return esnovedad
   **/
  
  @Schema(example = "true", description = "Indica si el contenido es una novedad.")
  
  public Boolean isEsnovedad() {  
    return esnovedad;
  }



  public void setEsnovedad(Boolean esnovedad) { 
    this.esnovedad = esnovedad;
  }

  public Contenido genero(Genero genero) { 

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

  public Contenido fotoamazon(String fotoamazon) { 

    this.fotoamazon = fotoamazon;
    return this;
  }

  /**
   * Nombre de la foto almacenada en Amazon.
   * @return fotoamazon
   **/
  
  @Schema(example = "foto123.jpg", description = "Nombre de la foto almacenada en Amazon.")
  
  public String getFotoamazon() {  
    return fotoamazon;
  }



  public void setFotoamazon(String fotoamazon) { 
    this.fotoamazon = fotoamazon;
  }

  public Contenido tipo(Integer tipo) { 

    this.tipo = tipo;
    return this;
  }

  /**
   * Tipo de contenido (por ejemplo, Álbum, Canción o Artista).
   * @return tipo
   **/
  
  @Schema(example = "0", required = true, description = "Tipo de contenido (por ejemplo, Álbum, Canción o Artista).")
  
@Valid
  @NotNull
  public Integer getTipo() {  
    return tipo;
  }



  public void setTipo(Integer tipo) { 

    this.tipo = tipo;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contenido contenido = (Contenido) o;
    return Objects.equals(this.id, contenido.id) &&
        Objects.equals(this.nombre, contenido.nombre) &&
        Objects.equals(this.fechacrea, contenido.fechacrea) &&
        Objects.equals(this.descripcion, contenido.descripcion) &&
        Objects.equals(this.numventas, contenido.numventas) &&
        Objects.equals(this.valoracion, contenido.valoracion) &&
        Objects.equals(this.precio, contenido.precio) &&
        Objects.equals(this.esnovedad, contenido.esnovedad) &&
        Objects.equals(this.genero, contenido.genero) &&
        Objects.equals(this.fotoamazon, contenido.fotoamazon) &&
        Objects.equals(this.tipo, contenido.tipo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, fechacrea, descripcion, numventas, valoracion, precio, esnovedad, genero, fotoamazon, tipo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contenido {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    fechacrea: ").append(toIndentedString(fechacrea)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    numventas: ").append(toIndentedString(numventas)).append("\n");
    sb.append("    valoracion: ").append(toIndentedString(valoracion)).append("\n");
    sb.append("    precio: ").append(toIndentedString(precio)).append("\n");
    sb.append("    esnovedad: ").append(toIndentedString(esnovedad)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    fotoamazon: ").append(toIndentedString(fotoamazon)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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

  public Integer getSubgeneroId() {
    if (subgenero != null) {
        return subgenero.getId();
    }
    return null;
  }

  public Genero getSubgenero() {
    return this.subgenero;
  }
    
  public void setSubgenero(Genero subgenero) {
    this.subgenero = subgenero;
  }
}
