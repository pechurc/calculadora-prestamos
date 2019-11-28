package com.eiv.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.eiv.enums.SistemaAmortizacionEnum;

public interface ILinea {
    
    Long getNumeroDocumento();
    
    Long getTipoDocumentoId();

    String getNombre();

    BigDecimal getTasaMin();

    BigDecimal getTasaMax();

    Integer getCuotasMin();

    Integer getCuotasMax();

    BigDecimal getCapitalMin();

    BigDecimal getCapitalMax();

    LocalDate getFechaAlta();

    SistemaAmortizacionEnum getSistemaAmortizacion();

}