package com.eiv.dtos;

import com.eiv.enums.RegionEnum;
import com.eiv.interfaces.IProvincia;

public class ProvinciaDto implements IProvincia {
    
    private String nombre;
    private RegionEnum region;
    
    public ProvinciaDto(String nombre, RegionEnum region) {
        
        this.nombre = nombre;
        this.region = region;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public RegionEnum getRegion() {
        return region;
    }

}
