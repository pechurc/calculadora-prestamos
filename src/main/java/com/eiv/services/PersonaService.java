package com.eiv.services;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.entities.LocalidadEntity;
import com.eiv.entities.PersonaEntity;
import com.eiv.entities.PersonaPkEntity;
import com.eiv.entities.TipoDocumentoEntity;
import com.eiv.interfaces.IPersona;
import com.eiv.repositories.PersonaRepository;
import com.eiv.utils.ExceptionUtils;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    
    @Autowired
    private LocalidadService localidadService;
    
    @Transactional(readOnly = true)
    public PersonaEntity getById(PersonaPkEntity pk) {
        
        return personaRepository
                .findById(pk)
                .orElseThrow(exceptionSupplier(pk));
    }
    
    @Transactional
    public PersonaEntity save(IPersona persona) {
        
        PersonaEntity personaEntity = new PersonaEntity();
        
        TipoDocumentoEntity tipoDocumento = tipoDocumentoService
                .getById(persona.getTipoDocumentoId());
        LocalidadEntity localidad = localidadService.getById(persona.getLocalidadId());
                
        personaEntity.setNumeroDocumento(persona.getNumeroDocumento());
        personaEntity.setTipoDocumento(tipoDocumento);
        personaEntity.setNombreApellido(persona.getNombreApellido());
        personaEntity.setFechaNacimiento(persona.getFechaNacimiento());
        personaEntity.setLocalidad(localidad);
        personaEntity.setCodigoPostal(persona.getCodigoPostal());
        personaEntity.setEsArgentino(persona.esArgentino());
        personaEntity.setGenero(persona.getGenero());
        personaEntity.setCorreoElectronico(persona.getCorreoElectronico());
        
        personaRepository.save(personaEntity);
        
        return personaEntity;
    }
    
    @Transactional
    public PersonaEntity update(PersonaPkEntity pk, IPersona persona) {

        PersonaEntity personaEntity = personaRepository
                .findById(pk)
                .orElseThrow(exceptionSupplier(pk));
        
        LocalidadEntity localidad = localidadService.getById(persona.getLocalidadId());        
        
        personaEntity.setNombreApellido(persona.getNombreApellido());
        personaEntity.setFechaNacimiento(persona.getFechaNacimiento());
        personaEntity.setLocalidad(localidad);
        personaEntity.setCodigoPostal(persona.getCodigoPostal());
        personaEntity.setEsArgentino(persona.esArgentino());
        personaEntity.setGenero(persona.getGenero());
        personaEntity.setCorreoElectronico(persona.getCorreoElectronico());
        
        personaRepository.save(personaEntity);
        
        return personaEntity;
    }
    
    @Transactional
    public void delete(PersonaPkEntity personaPk) {
     
        PersonaEntity personaEntity = personaRepository
                .findById(personaPk)
                .orElseThrow(exceptionSupplier(personaPk));
        
        personaRepository.delete(personaEntity);
    }
    
    // TODO: modificar esto para que quede mejor
    private Supplier<? extends RuntimeException> exceptionSupplier(PersonaPkEntity id) {
        
        return ExceptionUtils.notFoundExceptionSupplier("Persona con ID=%s no encontrada", id);
    }
}
