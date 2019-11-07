package com.eiv.converters;

import javax.persistence.Converter;

import com.eiv.enums.SistemaAmortizacionEnum;

@Converter(autoApply = true)
public class SistemaAmortizacionConverter 
    extends GenericConverter<SistemaAmortizacionEnum, Character>{

    public static SistemaAmortizacionConverter instance = new SistemaAmortizacionConverter();
    
    public SistemaAmortizacionConverter() {
        super(SistemaAmortizacionEnum.class);
    }
    
}
