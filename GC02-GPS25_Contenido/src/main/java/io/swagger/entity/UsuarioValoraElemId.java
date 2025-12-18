package io.swagger.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioValoraElemId implements Serializable{
    @Column(name = "IDUSER")
    private Integer idUser;

    @Column(name = "IDELEM")
    private Integer idElem;

    public UsuarioValoraElemId() {} 
    
    public UsuarioValoraElemId(Integer idUser2, Integer idElem2) {
        this.idUser = idUser2;
        this.idElem = idElem2;
    }
    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdElem() {
        return idElem;
    }
    public void setIdElem(Integer idElem) {
        this.idElem = idElem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioValoraElemId that = (UsuarioValoraElemId) o;

        if (!idUser.equals(that.idUser)) return false;
        return idElem.equals(that.idElem);
    }

    @Override
    public int hashCode() {
        int result = idUser.hashCode();
        result = 31 * result + idElem.hashCode();
        return result;
    }
}
