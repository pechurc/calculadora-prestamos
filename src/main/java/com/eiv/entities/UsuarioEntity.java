package com.eiv.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    
    @EmbeddedId
    private UsuarioPk id;
    
    @Column(name = "nombre_usuario", length = 50, nullable = false)
    private String nombreUsuario;
    
    @Column(name = "hashed_pwd", length = 200, nullable = false)
    private String hashedPwd;
    
    public UsuarioEntity() { }
    
    public UsuarioEntity(UsuarioPk id, String nombreUsuario, String hashed_pwd) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.hashedPwd = hashed_pwd;
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
        return hashedPwd;
    }
    
    public void setHashed_pwd(String hashed_pwd) {
        this.hashedPwd = hashed_pwd;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hashedPwd == null) ? 0 : hashedPwd.hashCode());
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
        if (hashedPwd == null) {
            if (other.hashedPwd != null) {
                return false;
            }
        } else if (!hashedPwd.equals(other.hashedPwd)) {
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
