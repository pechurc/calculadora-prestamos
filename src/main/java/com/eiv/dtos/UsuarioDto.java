package com.eiv.dtos;

import com.eiv.interfaces.IUsuario;

public class UsuarioDto implements IUsuario {

    private Long numeroDocumento;
    private Long tipoDocumentoId;
    private String nombreUsuario;
    private String hashedPwd;
    
    public UsuarioDto(Long numeroDocumento, Long tipoDocumentoId, String nombreUsuario, 
            String hashedPwd) {
        super();
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumentoId = tipoDocumentoId;
        this.nombreUsuario = nombreUsuario;
        this.hashedPwd = hashedPwd;
    }

    @Override
    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    @Override
    public Long getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    @Override
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    @Override
    public String getHashedPwd() {
        return hashedPwd;
    }

}
