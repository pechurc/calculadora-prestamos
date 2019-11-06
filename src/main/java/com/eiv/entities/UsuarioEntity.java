package com.eiv.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    
    @EmbeddedId
    private UsuarioPk id;
    
    private String nombreUsuario;
    private String hashed_pwd;
    
    public UsuarioEntity() { }
    
    public UsuarioEntity(UsuarioPk id, String nombreUsuario, String hashed_pwd) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.hashed_pwd = hashed_pwd;
    }

    public UsuarioPk getId() {
        return id;
    }
    
    public void setId(UsuarioPk id) {
        this.id = id;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getHashed_pwd() {
        return hashed_pwd;
    }
    
    public void setHashed_pwd(String hashed_pwd) {
        this.hashed_pwd = hashed_pwd;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hashed_pwd == null) ? 0 : hashed_pwd.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
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
        if (hashed_pwd == null) {
            if (other.hashed_pwd != null) {
                return false;
            }
        } else if (!hashed_pwd.equals(other.hashed_pwd)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
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
        return "UsuarioEntity [id=" + id + ", nombreUsuario=" + nombreUsuario + "]";
    }    
}
