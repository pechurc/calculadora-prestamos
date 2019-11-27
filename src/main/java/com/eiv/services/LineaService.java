package com.eiv.services;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.entities.LineaEntity;
import com.eiv.entities.PersonaPkEntity;
import com.eiv.entities.UsuarioEntity;
import com.eiv.interfaces.ILinea;
import com.eiv.repositories.LineaRepository;
import com.eiv.utils.ExceptionUtils;

@Service
public class LineaService {

    @Autowired
    private LineaRepository lineaRepository;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Transactional(readOnly = true)
    public LineaEntity getById(Integer id) {
        
        return lineaRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
    }
    
    @Transactional
    public LineaEntity save(ILinea linea) {
        
        LineaEntity lineaEntity = new LineaEntity();
        PersonaPkEntity personaPk = new PersonaPkEntity(linea.getNumeroDocumento(), 
                linea.getTipoDocumentoId());
        UsuarioEntity usuario = usuarioService.getById(personaPk);
        
        Integer id = lineaRepository.getMax().orElse(0) + 1;
        
        lineaEntity.setUsuario(usuario);
        lineaEntity.setCapitalMax(linea.getCapitalMax());
        lineaEntity.setCapitalMin(linea.getCapitalMin());
        lineaEntity.setCuotasMax(linea.getCuotasMax());
        lineaEntity.setCuotasMin(linea.getCuotasMin());
        lineaEntity.setFechaAlta(linea.getFechaAlta());
        lineaEntity.setNombre(linea.getNombre());
        lineaEntity.setSistemaAmortizacion(linea.getSistemaAmortizacion());
        lineaEntity.setTasaMax(linea.getTasaMax());
        lineaEntity.setTasaMin(linea.getTasaMin());
        lineaEntity.setId(id);
        
        lineaRepository.save(lineaEntity);
        
        return lineaEntity;
    }
    
    @Transactional
    public LineaEntity update(Integer id, ILinea linea) {
        
        LineaEntity lineaEntity = lineaRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));

        lineaEntity.setCapitalMax(linea.getCapitalMax());
        lineaEntity.setCapitalMin(linea.getCapitalMin());
        lineaEntity.setCuotasMax(linea.getCuotasMax());
        lineaEntity.setCuotasMin(linea.getCuotasMin());
        lineaEntity.setFechaAlta(linea.getFechaAlta());
        lineaEntity.setNombre(linea.getNombre());
        lineaEntity.setSistemaAmortizacion(linea.getSistemaAmortizacion());
        lineaEntity.setTasaMax(linea.getTasaMax());
        lineaEntity.setTasaMin(linea.getTasaMin());
        
        lineaRepository.save(lineaEntity);
        
        return lineaEntity;
    }
    
    @Transactional
    public void delete(Integer id) {
        
        LineaEntity lineaEntity = lineaRepository
                .findById(id)
                .orElseThrow(exceptionSupplier(id));
        
        lineaRepository.delete(lineaEntity);
    }
    
    private Supplier<? extends RuntimeException> exceptionSupplier(Integer id) {
        
        return ExceptionUtils.notFoundExceptionSupplier("Linea con ID=%s no encontrada", id);
    }   
}
