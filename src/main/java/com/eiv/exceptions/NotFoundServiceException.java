package com.eiv.exceptions;

public class NotFoundServiceException extends ServiceException{

    private static final long serialVersionUID = -8528748403251035579L;
    
    public NotFoundServiceException(String message, Object... args) {
        super(message, args);
    }

    @Override
    public int getCode() {
        return SERVICE_EXCEPTION_NOT_FOUND;
    }
}
