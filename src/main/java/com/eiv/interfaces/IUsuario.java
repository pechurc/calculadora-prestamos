package com.eiv.interfaces;

public interface IUsuario {
    
    public Long getNumeroDocumento();
    
    public Integer getTipoDocumentoId();
    
    public String getNombreUsuario();
    
    public String getHashedPwd();
}
