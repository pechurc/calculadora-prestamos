package com.eiv.enums;

public enum GeneroEnum implements GenericEnum<GeneroEnum, Character> {
    
    MASCULINO('M'),
    FEMENINO('F');
    
    private Character genero;
    
    private GeneroEnum(Character c) {
        this.genero = c;
    }
    
    public char getGenero() {
        return genero;
    }
    
    public static GeneroEnum of(Character c) {
        
        switch (Character.toUpperCase(c)) {
            case 'M':
                return MASCULINO;
            case 'F':
                return FEMENINO;
            default:
                throw new IllegalArgumentException(
                        String.format("No se reconoce %s como un genero", c));
        }
    }

    @Override
    public Character getId() {
        return genero;
    }
}
