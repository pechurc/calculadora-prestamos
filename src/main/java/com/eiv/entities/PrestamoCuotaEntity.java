package com.eiv.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "prestamos_cuotas")
public class PrestamoCuotaEntity {

    @EmbeddedId
    private PrestamoCuotaPk id;
    
    @Column(name = "importe_capital")
    private BigDecimal importeCapital;

    @Column(name = "importe_intereses")
    private BigDecimal importeIntereses;

    @Column(name = "importe_total")
    private BigDecimal importeTotal;

    public PrestamoCuotaEntity() { }

    public PrestamoCuotaPk getId() {
        return id;
    }

    public void setId(PrestamoCuotaPk id) {
        this.id = id;
    }

    public BigDecimal getImporteCapital() {
        return importeCapital;
    }

    public void setImporteCapital(BigDecimal importeCapital) {
        this.importeCapital = importeCapital;
    }

    public BigDecimal getImporteIntereses() {
        return importeIntereses;
    }

    public void setImporteIntereses(BigDecimal importeIntereses) {
        this.importeIntereses = importeIntereses;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((importeCapital == null) ? 0 : importeCapital.hashCode());
        result = prime * result + ((importeIntereses == null) ? 0 : importeIntereses.hashCode());
        result = prime * result + ((importeTotal == null) ? 0 : importeTotal.hashCode());
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
        PrestamoCuotaEntity other = (PrestamoCuotaEntity) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (importeCapital == null) {
            if (other.importeCapital != null) {
                return false;
            }
        } else if (!importeCapital.equals(other.importeCapital)) {
            return false;
        }
        if (importeIntereses == null) {
            if (other.importeIntereses != null) {
                return false;
            }
        } else if (!importeIntereses.equals(other.importeIntereses)) {
            return false;
        }
        if (importeTotal == null) {
            if (other.importeTotal != null) {
                return false;
            }
        } else if (!importeTotal.equals(other.importeTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrestamoCuotaEntity [id=" + id + ", importeCapital=" + importeCapital 
                + ", importeIntereses=" + importeIntereses + ", importeTotal=" + importeTotal + "]";
    } 
}