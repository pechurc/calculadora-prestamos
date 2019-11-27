package com.eiv.services;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.entities.PrestamoCuotaEntity;
import com.eiv.entities.PrestamoCuotaPk;
import com.eiv.entities.PrestamoEntity;
import com.eiv.interfaces.IPrestamoCuota;
import com.eiv.repositories.PrestamoCuotaRepository;
import com.eiv.utils.ExceptionUtils;

@Service
public class PrestamoCuotaService {

    @Autowired
    private PrestamoService prestamoService;
    
    @Autowired
    private PrestamoCuotaRepository prestamoCuotaRepository;
    
    @Transactional
    public PrestamoCuotaEntity save(IPrestamoCuota prestamoCuota) {
        
        PrestamoEntity prestamoEntity = prestamoService.getById(prestamoCuota.getPrestamoId());
        PrestamoCuotaEntity prestamoCuotaEntity = new PrestamoCuotaEntity();
        
        prestamoCuotaEntity.setPrestamo(prestamoEntity);
        prestamoCuotaEntity.setNroCuota(prestamoCuota.getNroCuota());
        prestamoCuotaEntity.setImporteCapital(prestamoCuota.getImporteCapital());
        prestamoCuotaEntity.setImporteIntereses(prestamoCuota.getImporteIntereses());
        prestamoCuotaEntity.setImporteTotal(prestamoCuota.getImproteTotal());
        
        prestamoCuotaRepository.save(prestamoCuotaEntity);
        
        return prestamoCuotaEntity;        
    }
    
    @Transactional
    public PrestamoCuotaEntity update(PrestamoCuotaPk pk, IPrestamoCuota prestamoCuota) {
        
        PrestamoCuotaEntity prestamoCuotaEntity = prestamoCuotaRepository
            .findById(pk)
            .orElseThrow(exceptionSupplier(pk));
        
        prestamoCuotaEntity.setImporteCapital(prestamoCuota.getImporteCapital());
        prestamoCuotaEntity.setImporteIntereses(prestamoCuota.getImporteIntereses());
        prestamoCuotaEntity.setImporteTotal(prestamoCuota.getImproteTotal());
        
        prestamoCuotaRepository.save(prestamoCuotaEntity);
        
        return prestamoCuotaEntity;
    }
    
    @Transactional
    public void delete(PrestamoCuotaPk pk) {
        
        PrestamoCuotaEntity prestamoCuotaEntity = prestamoCuotaRepository
                .findById(pk)
                .orElseThrow(exceptionSupplier(pk));
        
        prestamoCuotaRepository.delete(prestamoCuotaEntity);
    }
    
    private Supplier<? extends RuntimeException> exceptionSupplier(PrestamoCuotaPk id) {
        
        return ExceptionUtils.notFoundExceptionSupplier("Cuota con ID=%s no encontrada", id);
    }
}
