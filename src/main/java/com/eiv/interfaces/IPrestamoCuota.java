package com.eiv.interfaces;

import java.math.BigDecimal;

public interface IPrestamoCuota {

    public Long getPrestamoId();
    
    public Integer getNroCuota();
    
    public BigDecimal getImporteCapital();
    
    public BigDecimal getImporteIntereses();
    
    public BigDecimal getImproteTotal();
}
