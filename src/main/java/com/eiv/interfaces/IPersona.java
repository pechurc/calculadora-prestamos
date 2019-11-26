package com.eiv.interfaces;

import java.time.LocalDate;

import com.eiv.enums.GeneroEnum;

public interface IPersona {
    
    public Long getNumeroDocumento();
    
    public Integer getTipoDocumentoId();
    
    public String getNombreApellido();
    
    public String getCorreoElectronico();
    
    public Boolean esArgentino();
    
    public Integer getLocalidadId();
    
    public String getCodigoPostal();
    
    public GeneroEnum getGenero();
    
    public Byte[] getFotoCara();
    
    public LocalDate getFechaNacimiento();
}
