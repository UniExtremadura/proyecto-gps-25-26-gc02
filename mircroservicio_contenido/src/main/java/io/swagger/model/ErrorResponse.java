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
 * ErrorResponse
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")


public class ErrorResponse   {
  @JsonProperty("code")

  private Integer code = null;

  @JsonProperty("message")

  private String message = null;

  @JsonProperty("path")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String path = null;


  public ErrorResponse code(Integer code) { 

    this.code = code;
    return this;
  }

  /**
   * Código HTTP o interno del error
   * @return code
   **/
  
  @Schema(example = "400", required = true, description = "Código HTTP o interno del error")
  
  @NotNull
  public Integer getCode() {  
    return code;
  }



  public void setCode(Integer code) { 

    this.code = code;
  }

  public ErrorResponse message(String message) { 

    this.message = message;
    return this;
  }

  /**
   * Descripción legible del error
   * @return message
   **/
  
  @Schema(example = "Solicitud inválida", required = true, description = "Descripción legible del error")
  
  @NotNull
  public String getMessage() {  
    return message;
  }



  public void setMessage(String message) { 

    this.message = message;
  }

  public ErrorResponse path(String path) { 

    this.path = path;
    return this;
  }

  /**
   * Endpoint donde ocurrió el error
   * @return path
   **/
  
  @Schema(example = "/v1/usuarios", description = "Endpoint donde ocurrió el error")
  
  public String getPath() {  
    return path;
  }



  public void setPath(String path) { 
    this.path = path;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.code, errorResponse.code) &&
        Objects.equals(this.message, errorResponse.message) &&
        Objects.equals(this.path, errorResponse.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, path);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
