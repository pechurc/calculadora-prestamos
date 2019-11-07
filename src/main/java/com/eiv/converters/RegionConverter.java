package com.eiv.converters;

import javax.persistence.Converter;

import com.eiv.enums.RegionEnum;

@Converter(autoApply = true)
public class RegionConverter extends GenericConverter<RegionEnum, String> {

    public static RegionConverter instance = new RegionConverter();
    
    public RegionConverter() {
        super(RegionEnum.class);
    }

}
