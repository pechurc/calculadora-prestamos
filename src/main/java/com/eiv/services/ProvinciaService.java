package com.eiv.services;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.entities.ProvinciaEntity;
import com.eiv.interfaces.IProvincia;
import com.eiv.repositories.ProvinciaRepository;
import com.eiv.utils.ExceptionUtils;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Transactional(readOnly = true)
    public ProvinciaEntity getById(Long id) {
        return provinciaRepository.findById(id)
                .orElseThrow(exceptionSupplier(id));
    }
    
    @Transactional
    public ProvinciaEntity save(IProvincia provincia) {
        
        Long id = provinciaRepository.getMax().orElse(0L) + 1L;
        ProvinciaEntity provinciaEntity = new ProvinciaEntity();
        
        provinciaEntity.setId(id);
        provinciaEntity.setNombre(provincia.getNombre());
        provinciaEntity.setRegion(provincia.getRegion());
        
        provinciaRepository.save(provinciaEntity);
        
        return provinciaEntity;
    }
    
    @Transactional
    public ProvinciaEntity update(Long id, IProvincia provincia) {
        
        ProvinciaEntity provinciaEntity = provinciaRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
        
        provinciaEntity.setNombre(provincia.getNombre());
        provinciaEntity.setRegion(provincia.getRegion());
        
        provinciaRepository.save(provinciaEntity);
        
        return provinciaEntity;
    }
    
    @Transactional
    public void delete(Long id) {
        
        ProvinciaEntity provinciaEntity = provinciaRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
        
        provinciaRepository.delete(provinciaEntity);
    }
    
    private Supplier<? extends RuntimeException> exceptionSupplier(Long id) {
        
        return ExceptionUtils.notFoundExceptionSupplier("Provincia con ID=%s no encontrada", id);
    }
}
