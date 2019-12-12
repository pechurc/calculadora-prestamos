package com.eiv.criterias;

import java.lang.reflect.Field;

import javax.validation.ValidationException;

import com.querydsl.core.types.dsl.ComparableExpressionBase;

public abstract class ABaseCriteria {
	
	protected ComparableExpressionBase<?> getStringPath(String fieldName, Object o) {
		
		try {
			Field[] fields = o.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (field.getName().toLowerCase().equals(fieldName.toLowerCase())) {

					return (ComparableExpressionBase<?>) field.get(o);
				}
			}
			throw new ValidationException();
		} catch (Exception e) {
			throw new ValidationException();
		}
	}
}
