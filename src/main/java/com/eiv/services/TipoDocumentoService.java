package com.eiv.services;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.entities.QTipoDocumentoEntity;
import com.eiv.entities.TipoDocumentoEntity;
import com.eiv.interfaces.ITipoDocumento;
import com.eiv.repositories.TipoDocumentoRepository;
import com.eiv.utils.ExceptionUtils;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class TipoDocumentoService {
    
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    
    @Transactional(readOnly = true)
    public TipoDocumentoEntity getById(Long id) {
        
        return tipoDocumentoRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
    }
    
    @Transactional(readOnly = true)
    public List<TipoDocumentoEntity> findAll() {
    	return tipoDocumentoRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public List<TipoDocumentoEntity> findAll(Function<QTipoDocumentoEntity, BooleanExpression> function) {
    	
    	QTipoDocumentoEntity q = QTipoDocumentoEntity.tipoDocumentoEntity;    	
    	BooleanExpression exp = function.apply(q);
    	
    	return (List<TipoDocumentoEntity>)tipoDocumentoRepository.findAll(exp);
    }
    
    @Transactional
    public TipoDocumentoEntity save(ITipoDocumento tipoDocumento) {
        
        Long id = tipoDocumentoRepository.getMax().orElse(0L) + 1L;
        TipoDocumentoEntity tipoDocumentoEntity = new TipoDocumentoEntity();
        
        tipoDocumentoEntity.setId(id);
        tipoDocumentoEntity.setAbreviatura(tipoDocumento.getAbreviatura());
        tipoDocumentoEntity.setNombre(tipoDocumento.getNombre());
        tipoDocumentoEntity.setValidarComoCuit(tipoDocumento.validarComoCuit());
        
        tipoDocumentoRepository.save(tipoDocumentoEntity);
        
        return tipoDocumentoEntity;
    }
    
    @Transactional
    public TipoDocumentoEntity update(Long id, ITipoDocumento tipoDocumento) {
        
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
    public void delete(Long id) {
        
        TipoDocumentoEntity tipoDocumentoEntity = tipoDocumentoRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
        
        tipoDocumentoRepository.delete(tipoDocumentoEntity);
    }
    
    private Supplier<? extends RuntimeException> exceptionSupplier(Long id) {
        
        return ExceptionUtils.notFoundExceptionSupplier("Tipo documento con ID=%s no encontrada", id);
    }
}
