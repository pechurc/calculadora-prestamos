package com.eiv.converters;

import javax.persistence.Converter;

import com.eiv.enums.GeneroEnum;

@Converter(autoApply = true)
public class GeneroConverter extends GenericConverter<GeneroEnum, Character> {

    public static GeneroConverter instance = new GeneroConverter();
    
    public GeneroConverter() {
        super(GeneroEnum.class);
    }
    
}
