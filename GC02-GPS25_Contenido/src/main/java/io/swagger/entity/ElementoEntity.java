package io.swagger.entity;

import javax.persistence.*;

import java.time.LocalDateTime;

/**
 * Entidad JPA que representa la tabla ELEMENTOS en Oracle.
 */
@Entity
@Table(name = "ELEMENTOS")
public class ElementoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "FECHACREA", updatable = false)
    private LocalDateTime fechacrea;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "URL_FOTO")
    private String urlFoto;

    @Column(name = "NUMVENTAS")
    private Integer numventas;

    @Column(name = "VALORACION")
    private Integer valoracion;

    @Column(name = "PRECIO")
    private Float precio;

    @Column(name = "ESNOVEDAD")
    private Boolean esnovedad;

    @Column(name = "ESALBUM")
    private Boolean esalbum;

    @JoinColumn(name = "ID_GENERO")
    private Integer genero;

    @JoinColumn(name = "ID_SUBGENERO")
    private Integer subgenero;
    
    @Column(name = "ID_ARTISTA")
    private Integer artista;

    @PrePersist
    protected void onCreate() {
        this.fechacrea = LocalDateTime.now();
    }

    // --- Getters y Setters ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDateTime getFechacrea() { return fechacrea; }
    public void setFechacrea(LocalDateTime fechacrea) { this.fechacrea = fechacrea; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUrlFoto() { return urlFoto; }
    public void setUrlFoto(String urlFoto) { this.urlFoto = urlFoto; }

    public Integer getNumventas() { return numventas; }
    public void setNumventas(Integer numventas) { this.numventas = numventas; }

    public Integer getValoracion() { return valoracion; }
    public void setValoracion(Integer valoracion) { this.valoracion = valoracion; }

    public Float getPrecio() { return precio; }
    public void setPrecio(Float precio) { this.precio = precio; }

    public Boolean getEsnovedad() { return esnovedad; }
    public void setEsnovedad(Boolean esnovedad) { this.esnovedad = esnovedad; }

    public Boolean getEsalbum() { return esalbum; }
    public void setEsalbum(Boolean esalbum) { this.esalbum = esalbum; }

    public Integer getGenero() { return genero; }
    public void setGenero(Integer genero) { this.genero = genero; }

    public Integer getArtista() { return artista; }
    public void setArtista(Integer artista) { this.artista = artista; }

    public Integer getSubgenero() {return this.subgenero;}

    public void setSubgenero(Integer id2) {this.subgenero = id2;}
}
