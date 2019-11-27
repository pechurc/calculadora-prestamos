package com.eiv.services;



import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.entities.PersonaEntity;
import com.eiv.entities.PersonaPkEntity;
import com.eiv.entities.UsuarioEntity;
import com.eiv.interfaces.IUsuario;
import com.eiv.repositories.UsuarioRepository;
import com.eiv.utils.ExceptionUtils;

@Service
public class UsuarioService {

    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Transactional(readOnly = true)
    public UsuarioEntity getById(PersonaPkEntity pk) {
        
        return usuarioRepository
                .findById(pk)
                .orElseThrow(exceptionSupplier(pk));        
    }
    
    @Transactional
    public UsuarioEntity save(IUsuario usuario) {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(usuario.getNumeroDocumento(), 
                usuario.getTipoDocumentoId());
        PersonaEntity personaEntity = personaService.getById(personaPk);
        
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setPersona(personaEntity);
        usuarioEntity.setNombreUsuario(usuario.getNombreUsuario());
        usuarioEntity.setHashedPwd(usuario.getHashedPwd());
        
        usuarioRepository.save(usuarioEntity);
        
        return usuarioEntity;
    }
    
    @Transactional
    public UsuarioEntity update(PersonaPkEntity pk, IUsuario usuario) {
        
        UsuarioEntity usuarioEntity = usuarioRepository
                .findById(pk)
                .orElseThrow(exceptionSupplier(pk));
        
        usuarioEntity.setNombreUsuario(usuario.getNombreUsuario());
        usuarioEntity.setHashedPwd(usuario.getHashedPwd());
        
        usuarioRepository.save(usuarioEntity);
        
        return usuarioEntity;        
    }
    
    @Transactional
    public void delete(PersonaPkEntity pk) {
               
        UsuarioEntity usuarioEntity = usuarioRepository
                .findById(pk)
                .orElseThrow(exceptionSupplier(pk));
        
        usuarioRepository.delete(usuarioEntity);
    }
    
    private Supplier<? extends RuntimeException> exceptionSupplier(PersonaPkEntity id) {
        
        return ExceptionUtils.notFoundExceptionSupplier("Persona con ID=%s no encontrada", id);
    }    
}
