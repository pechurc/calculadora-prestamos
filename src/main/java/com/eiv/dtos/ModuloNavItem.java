package com.eiv.dtos;

import java.io.Serializable;
import java.util.List;

import com.eiv.interfaces.IModuloNavItem;
import com.eiv.interfaces.IModuloNavLink;

public class ModuloNavItem implements IModuloNavItem, Serializable {

    private static final long serialVersionUID = 5828458361983375382L;
    private String nombre;
    private String uri;
    private List<IModuloNavLink> navLinks;
    
    public ModuloNavItem() { 
    }
    
    public ModuloNavItem(String nombre, String uri) {
        this.nombre = nombre;
        this.uri = uri;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setUri(String uri) {
        this.uri = uri;
    }
    
    public void setNavLinks(List<IModuloNavLink> navLinks) {
        this.navLinks = navLinks;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public List<IModuloNavLink> getNavLinks() {
        return navLinks;
    }

    @Override
    public String getUri() {
        return uri;
    }

    @Override
    public String getDefaultUri() {
        if (!navLinks.isEmpty()) {
            return navLinks.get(0).getUri();
        } 
        return uri;
    }
    
}
