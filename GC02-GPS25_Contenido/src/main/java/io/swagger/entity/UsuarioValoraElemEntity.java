package io.swagger.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "usuario_valora_elem")
public class UsuarioValoraElemEntity {
    
    @EmbeddedId
    private UsuarioValoraElemId id; // Clave primaria compuesta por idUser e idElem

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idElem")
    @JoinColumn(name = "IDELEM")
    private ElementoEntity elemento;

    @Column(name = "IDUSER", insertable = false, updatable = false)
    private Integer idUser;

    @Column(name = "valoracion", nullable = false)
    private Integer valoracion;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "fechacomentario")
    private LocalDateTime fechaComentario;

    // Getters y Setters
    public UsuarioValoraElemId getId() {
        return id;
    }
    public void setId(UsuarioValoraElemId id) {
        this.id = id;
    }

    public Integer getValoracion() {
        return valoracion;
    }
    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public ElementoEntity getElemento() {
        return elemento;
    }
    public void setElemento(ElementoEntity elemento) {
        this.elemento = elemento;
    }

    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaComentario() {
        return fechaComentario;
    }
    public void setFechaComentario(LocalDateTime fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
    public void setFechaComentario(Date valueOf) {
        this.fechaComentario = valueOf.toLocalDate().atStartOfDay();
    }
}
