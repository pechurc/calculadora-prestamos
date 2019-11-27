package com.eiv.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.eiv.dtos.UsuarioDto;
import com.eiv.entities.PersonaEntity;
import com.eiv.entities.PersonaPkEntity;
import com.eiv.entities.UsuarioEntity;
import com.eiv.enums.GeneroEnum;
import com.eiv.exceptions.NotFoundServiceException;
import com.eiv.repositories.UsuarioRepository;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {

    @Mock
    PersonaService personaService;
    
    @Mock
    UsuarioRepository usuarioRepository;
        
    @InjectMocks
    UsuarioService usuarioService;
    
    @Test
    public void givenUsuarioDto_whenCreate_thenUsuarioEntityCreated() {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1);
        
        PersonaEntity personaEntity = new PersonaEntity(personaPk, 12345678L, null, 
                "Juan Tester", LocalDate.of(1990, 4, 4), "test@tester.com", true, null, 
                "2000SC", GeneroEnum.MASCULINO, null);
        
        when(personaService.getById(personaPk))
        .thenReturn(personaEntity);
        
        UsuarioEntity usuarioEntity = usuarioService
                .save(new UsuarioDto(12345678L, 1, "juantes", "asdqwe"));
        
        assertThat(usuarioEntity.getHashedPwd()).isEqualTo("asdqwe");
        assertThat(usuarioEntity.getNombreUsuario()).isEqualTo("juantes");
        assertThat(usuarioEntity.getPersona()).isEqualTo(personaEntity);
    }
    
    @Test
    public void givenUsuarioDto_whenUpdate_thenUsuarioEntityUpdated() {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1);
        
        PersonaEntity personaEntity = new PersonaEntity(personaPk, 12345678L, null, 
                "Juan Tester", LocalDate.of(1990, 4, 4), "test@tester.com", true, null, 
                "2000SC", GeneroEnum.MASCULINO, null);
        
        when(usuarioRepository.findById(personaPk))
        .thenReturn(Optional.of( new UsuarioEntity(personaEntity, "juantes", "asdqwe")));

        UsuarioEntity usuarioEntity = usuarioService
                .update(personaPk, new UsuarioDto(12345678L, 1, "juantes2", "asdqwe4"));
        
        assertThat(usuarioEntity.getHashedPwd()).isEqualTo("asdqwe4");
        assertThat(usuarioEntity.getNombreUsuario()).isEqualTo("juantes2");
        assertThat(usuarioEntity.getPersona()).isEqualTo(personaEntity);
    }
    
    @Test
    public void givenUsuarioDto_whenUpdateNonExists_thenThrowNotFoundServiceException() {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1);
        
        UsuarioDto usuarioDto = new UsuarioDto(12345678L, 1, "juantes", "asdqwe");

        Throwable throwable = catchThrowable(() -> usuarioService.update(personaPk, usuarioDto));
        
        assertThat(throwable)
        .isInstanceOf(NotFoundServiceException.class)
            .hasMessageContaining("Usuario con ID=PersonaPk "
                    + "[numeroDocumento=12345678, tipoDocumento=1] no encontrada");
    }
    
    @Test
    public void givenPersonaPk_thenDetele() {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1);      
        
        PersonaEntity personaEntity = new PersonaEntity(personaPk, 12345678L, null, 
                "Juan Tester", LocalDate.of(1990, 4, 4), "test@tester.com", true, null, 
                "2000SC", GeneroEnum.MASCULINO, null);
        UsuarioEntity usuarioEntity = new UsuarioEntity(personaEntity, "juantes", "asdqwe");
        
        Mockito.when(usuarioRepository.findById(personaPk))
        .thenReturn(Optional.of(usuarioEntity));
        
        usuarioService.delete(personaPk);
        
        Mockito.verify(usuarioRepository).findById(Mockito.eq(personaPk));
        Mockito.verify(usuarioRepository).delete(Mockito.eq(usuarioEntity));
    }
    
    @Test
    public void givenProvinciaId_whenDeleteNonExist_thenThrowException() {

        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1);
        Throwable throwable = catchThrowable(() -> usuarioService.delete(personaPk));
        
        assertThat(throwable)
                .isInstanceOf(NotFoundServiceException.class)
                .hasMessageContaining("Usuario con ID=PersonaPk "
                        + "[numeroDocumento=12345678, tipoDocumento=1] no encontrada");

        Mockito.verify(usuarioRepository).findById(Mockito.eq(personaPk));
        Mockito.verify(usuarioRepository, never()).delete(Mockito.any(UsuarioEntity.class));
    }
}
