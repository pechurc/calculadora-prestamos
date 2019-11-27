package com.eiv.dtos;

import com.eiv.interfaces.ILocalidad;

public class LocalidadDto implements ILocalidad {

    public String nombre;
    public String codigoPostal;
    public Integer provinciaId;
    
    public LocalidadDto(String nombre, String codigoPostal, Integer provinciaId) {
        
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.provinciaId = provinciaId;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getCodigoPostal() {
        return codigoPostal;
    }

    @Override
    public Integer getProvinciaId() {
        return provinciaId;
    }

}
