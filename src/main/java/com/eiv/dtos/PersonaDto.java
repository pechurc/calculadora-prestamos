package com.eiv.dtos;

import java.time.LocalDate;

import com.eiv.enums.GeneroEnum;
import com.eiv.interfaces.IPersona;

public class PersonaDto implements IPersona {
    
    private Long numeroDocumento;
    private Integer tipoDocumentoId;    
    private String nombreApellido;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    private Boolean esArgentino;
    private Integer localidadId;
    private String codigoPostal;
    private GeneroEnum genero;
    private Byte[] fotoCara;
    
    
    public PersonaDto(Long numeroDocumento, Integer tipoDocumentoId, String nombreApellido, LocalDate fechaNacimiento,
            String correoElectronico, Boolean esArgentino, Integer localidadId, String codigoPostal, GeneroEnum genero,
            Byte[] fotoCara) {
        super();
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumentoId = tipoDocumentoId;
        this.nombreApellido = nombreApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.esArgentino = esArgentino;
        this.localidadId = localidadId;
        this.codigoPostal = codigoPostal;
        this.genero = genero;
        this.fotoCara = fotoCara;
    }

    @Override
    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    @Override
    public Integer getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    @Override
    public String getNombreApellido() {
        return nombreApellido;
    }

    @Override
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    @Override
    public Boolean esArgentino() {
        return esArgentino;
    }

    @Override
    public Integer getLocalidadId() {
        return localidadId;
    }

    @Override
    public String getCodigoPostal() {
        return codigoPostal;
    }

    @Override
    public GeneroEnum getGenero() {
        return genero;
    }

    @Override
    public Byte[] getFotoCara() {
        return fotoCara;
    }

    @Override
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

}
