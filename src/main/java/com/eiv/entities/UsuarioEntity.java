package com.eiv.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    
    @EmbeddedId
    private PersonaPkEntity pk;
    
    @OneToOne
    @MapsId("personaPkEntity")
    @JoinColumns({ 
            @JoinColumn(name = "id_tipodocumento", referencedColumnName = "id_tipodocumento"),
            @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento") })
    private PersonaEntity persona;
    
    @Column(name = "nombre_usuario", length = 50, nullable = false)
    private String nombreUsuario;
    
    @Column(name = "hashed_pwd", length = 200, nullable = false)
    private String hashedPwd;
    
    public UsuarioEntity() { }
    
    public UsuarioEntity(PersonaPkEntity pk, String nombreUsuario, String hashed_pwd) {
        this.pk = pk;
        this.nombreUsuario = nombreUsuario;
        this.hashedPwd = hashed_pwd;
    }
    
    public UsuarioEntity(PersonaEntity persona, String nombreUsuario, String hashed_pwd) {
        this.persona = persona;
        this.pk = persona.getId();
        this.nombreUsuario = nombreUsuario;
        this.hashedPwd = hashed_pwd;
    }

    public PersonaPkEntity getId() {
        return pk;
    }
    
    public void setId(PersonaPkEntity id) {
        this.pk = id;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getHashedPwd() {
        return hashedPwd;
    }

    public void setHashedPwd(String hashedPwd) {
        this.hashedPwd = hashedPwd;
    }

    public PersonaEntity getPersona() {
        return persona;
    }

    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
        UsuarioEntity other = (UsuarioEntity) obj;
        if (hashedPwd == null) {
            if (other.hashedPwd != null) {
                return false;
            }
        } else if (!hashedPwd.equals(other.hashedPwd)) {
            return false;
        }
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }
        if (nombreUsuario == null) {
            if (other.nombreUsuario != null) {
                return false;
            }
        } else if (!nombreUsuario.equals(other.nombreUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioEntity [pk=" + pk + ", nombreUsuario=" + nombreUsuario + "]";
    }    
}
