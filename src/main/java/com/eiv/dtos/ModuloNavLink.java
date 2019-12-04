package com.eiv.dtos;

import java.io.Serializable;

public class ModuloNavLink implements IModuloNavLink, Serializable {

    private static final long serialVersionUID = 990337935640504410L;
    private String nombre;
    private String uri;
    
    
    public ModuloNavLink() {
    }

    public ModuloNavLink(String nombre, String uri) {
        this.nombre = nombre;
        this.uri = uri;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getUri() {
        return uri;
    }

}
