package com.eiv.services;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.entities.TipoDocumentoEntity;
import com.eiv.interfaces.ITipoDocumento;
import com.eiv.repositories.TipoDocumentoRepository;
import com.eiv.utils.ExceptionUtils;

@Service
public class TipoDocumentoService {
    
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    
    @Transactional(readOnly = true)
    public TipoDocumentoEntity getById(Integer id) {
        
        return tipoDocumentoRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
    }
    
    @Transactional
    public TipoDocumentoEntity save(ITipoDocumento tipoDocumento) {
        
        Integer id = tipoDocumentoRepository.getMax().orElse(0) + 1;
        TipoDocumentoEntity tipoDocumentoEntity = new TipoDocumentoEntity();
        
        tipoDocumentoEntity.setId(id);
        tipoDocumentoEntity.setAbreviatura(tipoDocumento.getAbreviatura());
        tipoDocumentoEntity.setNombre(tipoDocumento.getNombre());
        tipoDocumentoEntity.setValidarComoCuit(tipoDocumento.validarComoCuit());
        
        tipoDocumentoRepository.save(tipoDocumentoEntity);
        
        return tipoDocumentoEntity;
    }
    
    @Transactional
    public TipoDocumentoEntity update(Integer id, ITipoDocumento tipoDocumento) {
        
        TipoDocumentoEntity tipoDocumentoEntity = tipoDocumentoRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
        
        tipoDocumentoEntity.setAbreviatura(tipoDocumento.getAbreviatura());
        tipoDocumentoEntity.setNombre(tipoDocumento.getNombre());
        tipoDocumentoEntity.setValidarComoCuit(tipoDocumento.validarComoCuit());
        
        tipoDocumentoRepository.save(tipoDocumentoEntity);
        
        return tipoDocumentoEntity;
    }
    
    @Transactional
    public void delete(Integer id) {
        
        TipoDocumentoEntity tipoDocumentoEntity = tipoDocumentoRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
        
        tipoDocumentoRepository.delete(tipoDocumentoEntity);
    }
    
    private Supplier<? extends RuntimeException> exceptionSupplier(Integer id) {
        
        return ExceptionUtils.notFoundExceptionSupplier("Tipo documento con ID=%s no encontrada", id);
    }
}
