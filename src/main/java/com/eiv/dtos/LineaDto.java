package com.eiv.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.eiv.enums.SistemaAmortizacionEnum;
import com.eiv.interfaces.ILinea;

public class LineaDto implements ILinea {

    private Long numeroDocumento;
    private Long tipoDocumentoId;
    private String nombre;
    private BigDecimal tasaMin;
    private BigDecimal tasaMax;
    private Integer cuotasMin;
    private Integer cuotasMax;
    private BigDecimal capitalMin;
    private BigDecimal capitalMax;
    private LocalDate fechaAlta;
    private SistemaAmortizacionEnum sistemaAmortizacion;
    
    public LineaDto() {
        
    }
    
    public LineaDto(Long numeroDocumento, Long tipoDocumentoId, String nombre, 
            BigDecimal tasaMin, BigDecimal tasaMax, Integer cuotasMin, Integer cuotasMax, 
            BigDecimal capitalMin, BigDecimal capitalMax, LocalDate fechaAlta, 
            SistemaAmortizacionEnum sistemaAmortizacion) {
        super();
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumentoId = tipoDocumentoId;
        this.nombre = nombre;
        this.tasaMin = tasaMin;
        this.tasaMax = tasaMax;
        this.cuotasMin = cuotasMin;
        this.cuotasMax = cuotasMax;
        this.capitalMin = capitalMin;
        this.capitalMax = capitalMax;
        this.fechaAlta = fechaAlta;
        this.sistemaAmortizacion = sistemaAmortizacion;
    }

    @Override
    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    @Override
    public Long getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public BigDecimal getTasaMin() {
        return tasaMin;
    }

    @Override
    public BigDecimal getTasaMax() {
        return tasaMax;
    }

    @Override
    public Integer getCuotasMin() {
        return cuotasMin;
    }

    @Override
    public Integer getCuotasMax() {
        return cuotasMax;
    }

    @Override
    public BigDecimal getCapitalMin() {
        return capitalMin;
    }

    @Override
    public BigDecimal getCapitalMax() {
        return capitalMax;
    }

    @Override
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    @Override
    public SistemaAmortizacionEnum getSistemaAmortizacion() {
        return sistemaAmortizacion;
    }

}
