package com.eiv.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UsuarioPk implements Serializable {

    private static final long serialVersionUID = -7380538156246465628L;
    
    @Column(name = "numero_documento", nullable = false)
    private Long numeroDocumento;
    
    @ManyToOne
    @JoinColumn(name = "id_tipodocumento", referencedColumnName = "id_tipodocumento"
        , nullable = false)
    private TipoDocumentoEntity tipoDocumento;

    public UsuarioPk() { }
    
    public UsuarioPk(Long numeroDocumento, TipoDocumentoEntity tipoDocumento) {
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
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
        UsuarioPk other = (UsuarioPk) obj;
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
