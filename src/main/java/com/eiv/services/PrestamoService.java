package com.eiv.services;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.entities.PersonaPkEntity;
import com.eiv.entities.PrestamoEntity;
import com.eiv.entities.UsuarioEntity;
import com.eiv.interfaces.IPrestamo;
import com.eiv.repositories.PrestamoRepository;
import com.eiv.utils.ExceptionUtils;

@Service
public class PrestamoService {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private PrestamoRepository prestamoRepository;
    
    @Transactional(readOnly = true)
    public PrestamoEntity getById(Long prestamoId) {
        
        return prestamoRepository
                .findById(prestamoId)
                .orElseThrow(exceptionSupplier(prestamoId));
    }
    
    @Transactional
    public PrestamoEntity save(IPrestamo prestamo) {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(prestamo.getNumeroDocumento(), 
                prestamo.getTipoDocumentoId());
        UsuarioEntity usuario = usuarioService.getById(personaPk);
        PrestamoEntity prestamoEntity = new PrestamoEntity();
        
        Long id = prestamoRepository.getMax().orElse(0L) + 1L;
        
        prestamoEntity.setId(id);
        prestamoEntity.setUsuario(usuario);
        prestamoEntity.setTea(prestamo.getTea());
        prestamoEntity.setTeaModulo(prestamo.getTeaModulo());
        prestamoEntity.setCapitalPrestado(prestamo.getCapitalPrestado());
        prestamoEntity.setTotalIntereses(prestamo.getTotalIntereses());
        
        prestamoRepository.save(prestamoEntity);
        
        return prestamoEntity;
    }
    
    @Transactional
    public PrestamoEntity update(Long id, IPrestamo prestamo) {
        
        PrestamoEntity prestamoEntity = prestamoRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
        
        prestamoEntity.setTea(prestamo.getTea());
        prestamoEntity.setTeaModulo(prestamo.getTeaModulo());
        prestamoEntity.setCapitalPrestado(prestamo.getCapitalPrestado());
        prestamoEntity.setTotalIntereses(prestamo.getTotalIntereses());
        
        prestamoRepository.save(prestamoEntity);
        
        return prestamoEntity;
    }
    
    
    @Transactional
    public void delete(Long id) {
        
        PrestamoEntity prestamoEntity = prestamoRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
        
        prestamoRepository.delete(prestamoEntity);
    }
    
    private Supplier<? extends RuntimeException> exceptionSupplier(Long id) {
        
        return ExceptionUtils.notFoundExceptionSupplier("Prestamo con ID=%s no encontrada", id);
    }
   
}
