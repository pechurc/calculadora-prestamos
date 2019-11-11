package com.eiv.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioPkEntity implements Serializable {

    private static final long serialVersionUID = -7380538156246465628L;
    
    @Column(name = "numero_documento", nullable = false)
    private Integer numeroDocumento;
    
    @Column(name = "id_tipodocumento", nullable = false)
    private Integer tipoDocumento;

    public UsuarioPkEntity() { }
    
    public UsuarioPkEntity(Integer numeroDocumento, TipoDocumentoEntity tipoDocumento) {
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento.getId();
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public Integer getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroDocumento == null) ? 0 : numeroDocumento.hashCode());
        result = prime * result + ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UsuarioPkEntity other = (UsuarioPkEntity) obj;
        if (numeroDocumento == null) {
            if (other.numeroDocumento != null) {
                return false;
            }
        } else if (!numeroDocumento.equals(other.numeroDocumento)) {
            return false;
        }
        if (tipoDocumento == null) {
            if (other.tipoDocumento != null) {
                return false;
            }
        } else if (!tipoDocumento.equals(other.tipoDocumento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioPk [numeroDocumento=" + numeroDocumento + ", tipoDocumento=" 
                + tipoDocumento + "]";
    } 
    
}
