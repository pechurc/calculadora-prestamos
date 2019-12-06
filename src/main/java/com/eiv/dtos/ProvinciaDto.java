package com.eiv.dtos;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import com.eiv.entities.ProvinciaEntity;
import com.eiv.enums.RegionEnum;
import com.eiv.interfaces.IProvincia;

public class ProvinciaDto implements IProvincia {
    
	@NonNull
	@Length(min = 1, max = 200, message = "La longitud del nombre debe estar entre 1 y 200 caracteres")
    private String nombre;
    private RegionEnum region;
    private Long id;

	public ProvinciaDto() {

	}

	public ProvinciaDto(ProvinciaEntity provinciaEntity) {
		this.nombre = provinciaEntity.getNombre();
		this.region = provinciaEntity.getRegion();
	}
	
	public ProvinciaDto(String nombre, RegionEnum region) {
        
        this.nombre = nombre;
        this.region = region;
    }
    
    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRegion(RegionEnum region) {
		this.region = region;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public RegionEnum getRegion() {
        return region;
    }
    
	@Override
	public Long getId() {
		return id;
	}
    
	@Override
	public String toString() {
		return "ProvinciaDto [nombre=" + nombre + ", region=" + region + "]";
	}
}
