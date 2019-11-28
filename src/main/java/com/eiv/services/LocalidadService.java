package com.eiv.services;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.entities.LocalidadEntity;
import com.eiv.entities.ProvinciaEntity;
import com.eiv.interfaces.ILocalidad;
import com.eiv.repositories.LocalidadRepository;
import com.eiv.utils.ExceptionUtils;

@Service
public class LocalidadService {

     @Autowired
     private LocalidadRepository localidadRepository;
     
     @Autowired
     private ProvinciaService provinciaService;

     @Transactional(readOnly = true)
     public LocalidadEntity getById(Long id) {
         
         return localidadRepository
                 .findById(id)
                 .orElseThrow(exceptionSupplier(id));
     }
     
     @Transactional
     public LocalidadEntity save(ILocalidad localidad) {
         
         ProvinciaEntity provinciaEntity = provinciaService.getById(localidad.getProvinciaId());
         
         Long id = localidadRepository.getMax().orElse(0L) + 1L;
         LocalidadEntity localidadEntity = new LocalidadEntity();
         
         localidadEntity.setId(id);
         localidadEntity.setCodigoPostal(localidad.getCodigoPostal());
         localidadEntity.setNombre(localidad.getNombre());
         localidadEntity.setProvincia(provinciaEntity);
         
         localidadRepository.save(localidadEntity);
         
         return localidadEntity;
     }
     
     @Transactional
     public LocalidadEntity update(Long id, ILocalidad localidad) {
         
         ProvinciaEntity provinciaEntity = provinciaService.getById(localidad.getProvinciaId());
         LocalidadEntity localidadEntity = localidadRepository
                 .findById(id)
                 .orElseThrow(exceptionSupplier(id));
         
         localidadEntity.setNombre(localidad.getNombre());
         localidadEntity.setProvincia(provinciaEntity);
         localidadEntity.setCodigoPostal(localidad.getCodigoPostal());
         
         localidadRepository.save(localidadEntity);
         
         return localidadEntity;
     }
     
     @Transactional
     public void delete(Long id) {
         
         LocalidadEntity localidadEntity = localidadRepository
                 .findById(id)
                 .orElseThrow(exceptionSupplier(id));
         
         localidadRepository.delete(localidadEntity);
     }
     
     private Supplier<? extends RuntimeException> exceptionSupplier(Long id) {
         
         return ExceptionUtils.notFoundExceptionSupplier("Localidad con ID=%s no encontrada", id);
     }
}
