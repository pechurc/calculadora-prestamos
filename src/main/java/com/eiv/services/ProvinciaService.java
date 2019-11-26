package com.eiv.services;

import java.util.Optional;
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
    public Optional<ProvinciaEntity> findById(Integer id) {
        return provinciaRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public ProvinciaEntity getById(Integer id) {
        return provinciaRepository.findById(id)
                .orElseThrow(exceptionSupplier(id));
    }
    
    @Transactional
    public ProvinciaEntity nueva(IProvincia provincia) {
        
        Integer id = provinciaRepository.getMax().orElse(0) + 1;
        ProvinciaEntity provinciaEntity = new ProvinciaEntity();
        
        provinciaEntity.setId(id);
        provinciaEntity.setNombre(provincia.getNombre());
        provinciaEntity.setRegion(provincia.getRegion());
        
        provinciaRepository.save(provinciaEntity);
        
        return provinciaEntity;
    }
    
    @Transactional
    public ProvinciaEntity actualizar(Integer id, IProvincia provincia) {
        
        ProvinciaEntity provinciaEntity = provinciaRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
        
        provinciaEntity.setNombre(provincia.getNombre());
        provinciaEntity.setRegion(provincia.getRegion());
        
        provinciaRepository.save(provinciaEntity);
        
        return provinciaEntity;
    }
    
    @Transactional
    public void borrar(Integer id) {
        
        ProvinciaEntity provinciaEntity = provinciaRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
        
        provinciaRepository.delete(provinciaEntity);
    }
    
    private Supplier<? extends RuntimeException> exceptionSupplier(Integer id) {
        
        return ExceptionUtils.notFoundExceptionSupplier("Provincia con ID=%s no encontrada", id);
    }
}
