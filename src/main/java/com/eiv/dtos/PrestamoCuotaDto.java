package com.eiv.dtos;

import java.math.BigDecimal;

import com.eiv.interfaces.IPrestamoCuota;

public class PrestamoCuotaDto implements IPrestamoCuota {

    private Long prestamoId;
    private Integer nroCuota;
    private BigDecimal importeCapital;
    private BigDecimal importeIntereses;
    private BigDecimal importeTotal;
    
    public PrestamoCuotaDto(Long prestamoId, Integer nroCuota, BigDecimal importeCapital, 
            BigDecimal importeIntereses, BigDecimal importeTotal) {
        super();
        this.prestamoId = prestamoId;
        this.nroCuota = nroCuota;
        this.importeCapital = importeCapital;
        this.importeIntereses = importeIntereses;
        this.importeTotal = importeTotal;
    }

    @Override
    public Long getPrestamoId() {
        return prestamoId;
    }

    @Override
    public Integer getNroCuota() {
        return nroCuota;
    }

    @Override
    public BigDecimal getImporteCapital() {
        return importeCapital;
    }

    @Override
    public BigDecimal getImporteIntereses() {
        return importeIntereses;
    }

    @Override
    public BigDecimal getImproteTotal() {
        return importeTotal;
    }

}
