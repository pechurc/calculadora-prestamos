package com.eiv.converters;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;

import com.eiv.enums.GenericEnum;

public abstract class GenericConverter<X extends Enum<X> & GenericEnum<X, Id>, Id> 
    implements AttributeConverter<X, Id> {

    private Map<Id, X> map;

    public GenericConverter(Class<X> enumClass) {
        
        map = new HashMap<>();

        for (X e : enumClass.getEnumConstants()) {
            map.put(e.getId(), e);
        }
    }
    
    @Override
    public Id convertToDatabaseColumn(X attribute) {
        
        return attribute.getId();
    }

    @Override
    public X convertToEntityAttribute(Id dbData) {
        
        if (dbData == null) {
            return null;
        }
        
//        if (!map.containsKey(dbData)) {
//            throw new IllegalArgumentException(
//                    String.format("No existe un enum con id %s", dbData));
//        }
        
        return map.get(dbData);
    }
}
