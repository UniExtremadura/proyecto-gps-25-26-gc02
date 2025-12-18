package io.swagger.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad JPA que representa la tabla CANCION en la base de datos Oracle.
 */
@Entity
@Table(name = "CANCIONES")
public class CancionEntity implements Serializable {

    @Id
    @Column(name = "IDELEMENTO")
    private Integer id;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "IDELEMENTO")
    private ElementoEntity elemento;

    @Column(name = "NOMBREAUDIO", nullable = false, length = 100)
    private String nombreAudio;

    @Column(name = "NUMREP", nullable = false)
    private Integer numRep = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDALBUM")
    private ElementoEntity album;

    // =============================
    // Getters y Setters
    // =============================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ElementoEntity getElemento() {
        return elemento;
    }

    public void setElemento(ElementoEntity elemento) {
        this.elemento = elemento;
    }

    public String getNombreAudio() {
        return nombreAudio;
    }

    public void setNombreAudio(String nombreAudio) {
        this.nombreAudio = nombreAudio;
    }

    public Integer getNumRep() {
        return numRep;
    }

    public void setNumRep(Integer numRep) {
        this.numRep = numRep;
    }

    public ElementoEntity getAlbum() {
        return album;
    }

    public void setAlbum(ElementoEntity album) {
        this.album = album;
    }

    // =============================
    // Métodos auxiliares
    // =============================

    @Override
    public String toString() {
        return "CancionEntity{" +
                "id=" + id +
                ", nombreAudio='" + nombreAudio + '\'' +
                ", numRep=" + numRep +
                ", idAlbum=" + (album != null ? album.getId() : null) +
                '}';
    }
}
