package com.eiv.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.eiv.interfaces.IPrestamo;

public class PrestamoDto implements IPrestamo {

    private Long numeroDocumento;
    private Long tipoDocumentoId;
    private LocalDate fechaAlta;
    private BigDecimal tea;
    private BigDecimal teaModulo;
    private BigDecimal capitalPrestado;
    private BigDecimal totalIntereses;
    
    public PrestamoDto(Long numeroDocumento, Long tipoDocumentoId, LocalDate fechaAlta, 
            BigDecimal tea, BigDecimal teaModulo, BigDecimal capitalPrestado,
            BigDecimal totalIntereses) {
        super();
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumentoId = tipoDocumentoId;
        this.fechaAlta = fechaAlta;
        this.tea = tea;
        this.teaModulo = teaModulo;
        this.capitalPrestado = capitalPrestado;
        this.totalIntereses = totalIntereses;
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
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    @Override
    public BigDecimal getTea() {
        return tea;
    }

    @Override
    public BigDecimal getTeaModulo() {
        return teaModulo;
    }

    @Override
    public BigDecimal getCapitalPrestado() {
        return capitalPrestado;
    }

    @Override
    public BigDecimal getTotalIntereses() {
        return totalIntereses;
    }

}
