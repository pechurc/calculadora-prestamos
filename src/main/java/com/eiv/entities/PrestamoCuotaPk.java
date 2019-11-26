package com.eiv.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PrestamoCuotaPk implements Serializable {

    private static final long serialVersionUID = 8878257701407645703L;
    
    @Column(name = "prestamo_id", nullable = false)
    private Integer prestamoId;
    
    @Column(name = "nro_cuota", nullable = false)
    private Integer nroCuota;
    
    public PrestamoCuotaPk() { }

    public Integer getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(Integer prestamoId) {
        this.prestamoId = prestamoId;
    }

    public Integer getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(Integer nroCuota) {
        this.nroCuota = nroCuota;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nroCuota == null) ? 0 : nroCuota.hashCode());
        result = prime * result + ((prestamoId == null) ? 0 : prestamoId.hashCode());
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
        PrestamoCuotaPk other = (PrestamoCuotaPk) obj;
        if (nroCuota == null) {
            if (other.nroCuota != null) {
                return false;
            }
        } else if (!nroCuota.equals(other.nroCuota)) {
            return false;
        }
        if (prestamoId == null) {
            if (other.prestamoId != null) {
                return false;
            }
        } else if (!prestamoId.equals(other.prestamoId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrestamoCuotaPk [prestamo=" + prestamoId + ", nroCuota=" + nroCuota + "]";
    }   
}
