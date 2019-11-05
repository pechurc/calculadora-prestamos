package com.eiv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_documentos")
public class TipoDocumentoEntity {

    @Id
    @Column(name = "id_tipodocumento", nullable = false)
    private Long id;
    
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;
    
    @Column(name = "abreviatura", nullable = false, unique = true)
    private String abreviatura;
    
    @Column(name = "validar_como_cuit", nullable = false)
    private Boolean validarComoCuit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Boolean getValidarComoCuit() {
        return validarComoCuit;
    }

    public void setValidarComoCuit(Boolean validarComoCuit) {
        this.validarComoCuit = validarComoCuit;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((abreviatura == null) ? 0 : abreviatura.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((validarComoCuit == null) ? 0 : validarComoCuit.hashCode());
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
        TipoDocumentoEntity other = (TipoDocumentoEntity) obj;
        if (abreviatura == null) {
            if (other.abreviatura != null) {
                return false;
            }
        } else if (!abreviatura.equals(other.abreviatura)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (nombre == null) {
            if (other.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(other.nombre)) {
            return false;
        }
        if (validarComoCuit == null) {
            if (other.validarComoCuit != null) {
                return false;
            }
        } else if (!validarComoCuit.equals(other.validarComoCuit)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoDocumento [id=" + id + ", nombre=" + nombre + "]";
    }
    
}
