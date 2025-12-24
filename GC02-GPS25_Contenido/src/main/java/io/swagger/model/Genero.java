package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import io.swagger.configuration.NotUndefined;
import javax.validation.constraints.*;

/**
 * Genero
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")


public class Genero   {
  @JsonProperty("id")

  private Integer id = null;

  @JsonProperty("nombre")

  private String nombre = null;


  public Genero id(Integer id) { 

    this.id = id;
    return this;
  }

  /**
   * Identificador único del género musical
   * @return id
   **/
  
  @Schema(example = "3", required = true, description = "Identificador único del género musical")
  
  @NotNull
  public Integer getId() {  
    return id;
  }



  public void setId(Integer id) { 

    this.id = id;
  }

  public Genero nombre(String nombre) { 

    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre del género musical
   * @return nombre
   **/
  
  @Schema(example = "Rock", required = true, description = "Nombre del género musical")
  
  @NotNull
@Size(max=100)   public String getNombre() {  
    return nombre;
  }



  public void setNombre(String nombre) { 

    this.nombre = nombre;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Genero genero = (Genero) o;
    return Objects.equals(this.id, genero.id) &&
        Objects.equals(this.nombre, genero.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Genero {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
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
