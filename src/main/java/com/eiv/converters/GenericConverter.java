package com.eiv.converters;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;

import com.eiv.enums.GenericEnum;

public abstract class GenericConverter<X extends Enum<X> & GenericEnum<Id>, Id> 
    implements AttributeConverter<X, Id> {

    private Map<Id, X> map;
    private Boolean notNull = false;

    public GenericConverter(Class<X> enumClass) {
        
        map = new HashMap<>();

        for (X e : enumClass.getEnumConstants()) {
            map.put(e.getId(), e);
        }
    }
    
    /**
     * Si notNull es true se lanzara una excepcion si no se encuentra el valor 
     * @param enumClass
     * @param notNull
     */
    public GenericConverter(Class<X> enumClass, Boolean notNull) {
        
        this.notNull = notNull;

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
        
        if (notNull) {
          if (!map.containsKey(dbData)) {
              throw new IllegalArgumentException(
                      String.format("No existe un enum con id %s", dbData));
          }
        }
        
        return map.get(dbData);
    }
    
    public Boolean getNotNull() {
        return notNull;
    }

    public void setNotNull(Boolean notNull) {
        this.notNull = notNull;
    }
}
