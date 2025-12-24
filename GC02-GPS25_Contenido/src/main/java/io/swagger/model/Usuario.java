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
 * Usuario
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-11-10T17:11:09.236506587Z[GMT]")


public class Usuario   {
  @JsonProperty("id")

  private Integer id = null;

  @JsonProperty("nombreusuario")

  private String nombreUsuario = null;

  @JsonProperty("nombrereal")

  private String nombreReal = null;

  @JsonProperty("correo")

  private String correo = null;

  @JsonProperty("descripcion")

  private String descripcion = null;

  @JsonProperty("fechaRegistro")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private OffsetDateTime fechaRegistro = null;

  @JsonProperty("rutafoto")

  private String rutaFoto = null;


  public Usuario id(Integer id) { 

    this.id = id;
    return this;
  }

  /**
   * Identificador único del usuario
   * @return id
   **/
  
  @Schema(example = "1", required = true, description = "Identificador único del usuario")
  
  @NotNull
  public Integer getId() {  
    return id;
  }



  public void setId(Integer id) { 

    this.id = id;
  }

  public Usuario nombreUsuario(String nombreUsuario) { 

    this.nombreUsuario = nombreUsuario;
    return this;
  }

  /**
   * Nombre de usuario en la web
   * @return nombreUsuario
   **/
  
  @Schema(example = "carlos123", required = true, description = "Nombre de usuario en la web")
  
  @NotNull
@Size(max=50)   public String getNombreUsuario() {  
    return nombreUsuario;
  }



  public void setNombreUsuario(String nombreUsuario) { 

    this.nombreUsuario = nombreUsuario;
  }

  public Usuario nombreReal(String nombreReal) { 

    this.nombreReal = nombreReal;
    return this;
  }

  /**
   * Nombre completo del usuario
   * @return nombreReal
   **/
  
  @Schema(example = "Carlos Pérez", required = true, description = "Nombre completo del usuario")
  
  @NotNull
@Size(max=100)   public String getNombreReal() {  
    return nombreReal;
  }



  public void setNombreReal(String nombreReal) { 

    this.nombreReal = nombreReal;
  }

  public Usuario correo(String correo) { 

    this.correo = correo;
    return this;
  }

  /**
   * Correo electrónico del usuario
   * @return correo
   **/
  
  @Schema(example = "carlos@example.com", required = true, description = "Correo electrónico del usuario")
  
  @NotNull
  public String getCorreo() {  
    return correo;
  }



  public void setCorreo(String correo) { 

    this.correo = correo;
  }

  public Usuario descripcion(String descripcion) { 

    this.descripcion = descripcion;
    return this;
  }

  /**
   * Descripción o biografía del usuario
   * @return descripcion
   **/
  
  @Schema(example = "Apasionado por la música y la producción digital.", description = "Descripción o biografía del usuario")
  
@Size(max=256)   public String getDescripcion() {
 
    return descripcion;
  }



  public void setDescripcion(String descripcion) { 
    this.descripcion = descripcion;
  }

  public Usuario fechaRegistro(OffsetDateTime fechaRegistro) { 

    this.fechaRegistro = fechaRegistro;
    return this;
  }

  /**
   * Fecha y hora en que se registró el usuario
   * @return fechaRegistro
   **/
  
  @Schema(example = "2025-10-14T18:45Z", description = "Fecha y hora en que se registró el usuario")
  
@Valid
  public OffsetDateTime getFechaRegistro() {  
    return fechaRegistro;
  }



  public void setFechaRegistro(OffsetDateTime fechaRegistro) { 
    this.fechaRegistro = fechaRegistro;
  }

  public Usuario rutaFoto(String rutaFoto) { 

    this.rutaFoto = rutaFoto;
    return this;
  }

  /**
   * URL o ruta de la imagen de perfil del usuario
   * @return rutaFoto
   **/
  
  @Schema(example = "https://cdn.misitio.com/usuarios/1/perfil.jpg", description = "URL o ruta de la imagen de perfil del usuario")
  
@Size(max=255)   public String getRutaFoto() {
 
    return rutaFoto;
  }



  public void setRutaFoto(String rutaFoto) { 
    this.rutaFoto = rutaFoto;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Usuario usuario = (Usuario) o;
    return Objects.equals(this.id, usuario.id) &&
        Objects.equals(this.nombreUsuario, usuario.nombreUsuario) &&
        Objects.equals(this.nombreReal, usuario.nombreReal) &&
        Objects.equals(this.correo, usuario.correo) &&
        Objects.equals(this.descripcion, usuario.descripcion) &&
        Objects.equals(this.fechaRegistro, usuario.fechaRegistro) &&
        Objects.equals(this.rutaFoto, usuario.rutaFoto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombreUsuario, nombreReal, correo, descripcion, fechaRegistro, rutaFoto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Usuario {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombreUsuario: ").append(toIndentedString(nombreUsuario)).append("\n");
    sb.append("    nombreReal: ").append(toIndentedString(nombreReal)).append("\n");
    sb.append("    correo: ").append(toIndentedString(correo)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    fechaRegistro: ").append(toIndentedString(fechaRegistro)).append("\n");
    sb.append("    rutaFoto: ").append(toIndentedString(rutaFoto)).append("\n");
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
