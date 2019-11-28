package com.eiv.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IPrestamo {

    public Long getNumeroDocumento();
    
    public Long getTipoDocumentoId();
    
    public LocalDate getFechaAlta();
    
    public BigDecimal getTea();
    
    public BigDecimal getTeaModulo();
    
    public BigDecimal getCapitalPrestado();
    
    public BigDecimal getTotalIntereses();
}
