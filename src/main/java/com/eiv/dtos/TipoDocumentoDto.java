package com.eiv.dtos;

import com.eiv.interfaces.ITipoDocumento;

public class TipoDocumentoDto implements ITipoDocumento {

    private String nombre;
    private String abreviatura;
    private Boolean validarComoCuit;
    
    public TipoDocumentoDto() {

    }
    
    public TipoDocumentoDto(String nombre, String abreviatura, Boolean validarComoCuit) {
        super();
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.validarComoCuit = validarComoCuit;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getAbreviatura() {
        return abreviatura;
    }

    @Override
    public Boolean validarComoCuit() {
        return validarComoCuit;
    }

}
