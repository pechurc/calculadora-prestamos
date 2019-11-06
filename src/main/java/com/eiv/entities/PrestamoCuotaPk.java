package com.eiv.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PrestamoCuotaPk implements Serializable {

    private static final long serialVersionUID = 8878257701407645703L;
    
    @ManyToOne
    @JoinColumn(name = "prestamo_id", referencedColumnName = "prestamo_id", nullable = false)
    private PrestamoEntity prestamo;
    
    @Column(name = "nro_cuota", nullable = false)
    private Integer nroCuota;
    
    public PrestamoCuotaPk() { }

    public PrestamoEntity getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(PrestamoEntity prestamo) {
        this.prestamo = prestamo;
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
        result = prime * result + ((prestamo == null) ? 0 : prestamo.hashCode());
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
        if (prestamo == null) {
            if (other.prestamo != null) {
                return false;
            }
        } else if (!prestamo.equals(other.prestamo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrestamoCuotaPk [prestamo=" + prestamo + ", nroCuota=" + nroCuota + "]";
    }   
}
