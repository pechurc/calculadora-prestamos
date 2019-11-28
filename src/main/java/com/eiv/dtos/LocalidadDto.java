package com.eiv.dtos;

import com.eiv.interfaces.ILocalidad;

public class LocalidadDto implements ILocalidad {

    public String nombre;
    public String codigoPostal;
    public Long provinciaId;
    
    public LocalidadDto(String nombre, String codigoPostal, Long provinciaId) {
        
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
    public Long getProvinciaId() {
        return provinciaId;
    }

}
