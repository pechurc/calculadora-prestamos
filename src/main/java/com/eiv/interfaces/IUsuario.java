package com.eiv.interfaces;

public interface IUsuario {
    
    public Long getNumeroDocumento();
    
    public Long getTipoDocumentoId();
    
    public String getNombreUsuario();
    
    public String getHashedPwd();
}
