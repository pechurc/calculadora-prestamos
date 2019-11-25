package com.eiv.exceptions;

public abstract class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -7614591648843455808L;
    
    public static final int SERVICE_EXCEPTION_NOT_FOUND = 100;

    public ServiceException(String message, Object... args) {
        super(String.format(message, args));
    }
    
    public abstract int getCode();
}
