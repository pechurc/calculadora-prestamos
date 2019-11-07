package com.eiv.enums;

public enum SistemaAmortizacionEnum implements GenericEnum<Character>{
    ALEMAN('G'),
    FRANCES('F'),
    AMERICANO('A');
    
    private Character codigo;
    
    private SistemaAmortizacionEnum(Character c) {
        this.codigo = c;
    }
    
    public static SistemaAmortizacionEnum of(Character c) {
        
        switch(c) {
            case 'G':
                return ALEMAN;
            case 'F':
                return FRANCES;
            case 'A':
                return AMERICANO;
            default:
                throw new IllegalArgumentException(
                        String.format("No se reconoce %s como un sistema de amortizacion", c));
        }
    }
    
    public Character getCodigo() {
        return this.codigo;
    }

    @Override
    public Character getId() {
        return this.codigo;
    }
}
