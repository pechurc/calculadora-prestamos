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
}
