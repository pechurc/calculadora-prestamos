package com.eiv.dtos;

import java.util.List;

public interface IModuloNavItem {

    public String getNombre();
    
    public List<IModuloNavLink> getNavLinks();
    
    public void setNavLinks(List<IModuloNavLink> navLinks);
    
    public String getUri();
    
    public String getDefaultUri();
}
