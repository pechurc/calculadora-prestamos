package com.eiv.utils;

import java.util.function.Supplier;

import com.eiv.exceptions.NotFoundServiceException;

public class ExceptionUtils {
    
    public static Supplier<? extends RuntimeException> notFoundExceptionSupplier(String message, 
            Integer id) {
        
        return () -> new NotFoundServiceException(message, id);
    }
    
    public static Supplier<? extends RuntimeException> notFoundExceptionSupplier(String message, 
            Object obj) {
        
        return () -> new NotFoundServiceException(message, obj);
    }
}
