package com.eiv.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.never;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.eiv.dtos.PersonaDto;
import com.eiv.entities.LocalidadEntity;
import com.eiv.entities.PersonaEntity;
import com.eiv.entities.PersonaPkEntity;
import com.eiv.entities.ProvinciaEntity;
import com.eiv.entities.TipoDocumentoEntity;
import com.eiv.enums.GeneroEnum;
import com.eiv.enums.RegionEnum;
import com.eiv.exceptions.NotFoundServiceException;
import com.eiv.repositories.PersonaRepository;

@RunWith(MockitoJUnitRunner.class)
public class PersonaServiceTest {
    
    @Mock
    PersonaRepository personaRepository;
    
    @Mock
    TipoDocumentoService tipoDocumentoService;
    
    @Mock 
    LocalidadService localidadService;
    
    @InjectMocks
    PersonaService personaService;
    
    @Test
    public void givenPersonaDto_whenCreate_thenPersonaEntityCreated() {
        
        Mockito.when(localidadService.getById(1L))
        .thenReturn(new LocalidadEntity(1L, "LocalidadTest", "2000",
                new ProvinciaEntity(1L, "ProvinciaTest", RegionEnum.CUYO)));
        
        Mockito.when(tipoDocumentoService.getById(1L))
        .thenReturn(new TipoDocumentoEntity(1L, "DNI", "DNI", false));

        PersonaDto personaDto = new PersonaDto(32569874L, 1L, "Juan Tester", 
                LocalDate.of(1990, 4, 4), "test@tester.com", true, 1L, "2000SC",
                GeneroEnum.MASCULINO, null);
        
        PersonaEntity personaEntity = personaService.save(personaDto);
        
        assertThat(personaEntity.getNumeroDocumento()).isEqualTo(32569874L);
        assertThat(personaEntity.getCodigoPostal()).isEqualTo("2000SC");
        assertThat(personaEntity.getCorreoElectronico()).isEqualTo("test@tester.com");
        assertThat(personaEntity.getFechaNacimiento()).isEqualTo(LocalDate.of(1990, 4, 4));
        assertThat(personaEntity.getEsArgentino()).isEqualTo(true);
        assertThat(personaEntity.getGenero()).isEqualTo(GeneroEnum.MASCULINO);
        assertThat(personaEntity.getLocalidad().getNombre()).isEqualTo("LocalidadTest");
        assertThat(personaEntity.getTipoDocumento().getNombre()).isEqualTo("DNI");
    }
    
    @Test
    public void givenPersonaDto_whenUpdate_thenPersonaEntityUpdated() {
        
        LocalidadEntity localidad = new LocalidadEntity(1L, "LocalidadTest", "2000",
                new ProvinciaEntity(1L, "ProvinciaTest", RegionEnum.CUYO));
        
        LocalidadEntity localidad2 = new LocalidadEntity(2L, "Localidad2Test", "2000",
                new ProvinciaEntity(2L, "Provincia2Test", RegionEnum.CUYO));

        Mockito.when(localidadService.getById(2L))
        .thenReturn(localidad2);
        
        TipoDocumentoEntity tipoDocumento = new TipoDocumentoEntity(1L, "DNI", "DNI", false);
        
        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1L);
        
        Mockito.when(personaRepository.findById(personaPk))
        .thenReturn(Optional.of(new PersonaEntity(personaPk, 12345678L, tipoDocumento, "Juan Tester",
                LocalDate.of(1990, 4, 4), "test@tester.com", true, localidad, "2000SC",
                GeneroEnum.MASCULINO, null)));

        PersonaDto personaDto = new PersonaDto(12345678L, 1L, "Juan Tester 2", 
                LocalDate.of(1990, 5, 5), "mod@tester.com", true, 2L, "2001SC",
                GeneroEnum.FEMENINO, null);
        
        PersonaEntity personaEntity = personaService.update(personaPk, personaDto);
        
        assertThat(personaEntity.getNombreApellido()).isEqualTo("Juan Tester 2");
        assertThat(personaEntity.getCodigoPostal()).isEqualTo("2001SC");
        assertThat(personaEntity.getCorreoElectronico()).isEqualTo("mod@tester.com");
        assertThat(personaEntity.getFechaNacimiento()).isEqualTo(LocalDate.of(1990, 5, 5));
        assertThat(personaEntity.getEsArgentino()).isEqualTo(true);
        assertThat(personaEntity.getGenero()).isEqualTo(GeneroEnum.FEMENINO);
        assertThat(personaEntity.getLocalidad()).isEqualTo(localidad2);
        assertThat(personaEntity.getTipoDocumento().getNombre()).isEqualTo("DNI");
    }
    
    @Test
    public void givenPersonaDto_whenUpdateNonExists_thenThrowNotFoundServiceException() {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1L);
        
        PersonaDto personaDto = new PersonaDto(12345678L, 1L, "Juan Tester 2", 
                LocalDate.of(1990, 5, 5), "mod@tester.com", true, 2L, "2001SC",
                GeneroEnum.FEMENINO, null);

        Throwable throwable = catchThrowable(() -> personaService.update(personaPk, personaDto));
        
        assertThat(throwable)
        .isInstanceOf(NotFoundServiceException.class)
            .hasMessageContaining("Persona con ID=PersonaPk "
                    + "[numeroDocumento=12345678, tipoDocumento=1] no encontrada");
    }
        
    @Test
    public void givenPersonaPk_thenDetele() {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1L);      
        
        LocalidadEntity localidad = new LocalidadEntity(1L, "LocalidadTest", "2000",
                new ProvinciaEntity(1L, "ProvinciaTest", RegionEnum.CUYO));
        TipoDocumentoEntity tipoDocumento = new TipoDocumentoEntity(1L, "DNI", "DNI", false);
        PersonaEntity personaEntity = new PersonaEntity(personaPk, 12345678L, tipoDocumento, 
                "Juan Tester", LocalDate.of(1990, 4, 4), "test@tester.com", true, localidad, 
                "2000SC", GeneroEnum.MASCULINO, null);
        
        Mockito.when(personaRepository.findById(personaPk))
        .thenReturn(Optional.of(personaEntity));
        
        personaService.delete(personaPk);
        
        Mockito.verify(personaRepository).findById(Mockito.eq(personaPk));
        Mockito.verify(personaRepository).delete(Mockito.eq(personaEntity));
    }
    
    @Test
    public void givenProvinciaId_whenDeleteNonExist_thenThrowException() {

        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1L);
        Throwable throwable = catchThrowable(() -> personaService.delete(personaPk));
        
        assertThat(throwable)
                .isInstanceOf(NotFoundServiceException.class)
                .hasMessageContaining("Persona con ID=PersonaPk "
                        + "[numeroDocumento=12345678, tipoDocumento=1] no encontrada");

        Mockito.verify(personaRepository).findById(Mockito.eq(personaPk));
        Mockito.verify(personaRepository, never()).delete(Mockito.any(PersonaEntity.class));
    }
    
    @Test
    public void givenPersonaId_whenExists_thenPersonaEntityReturned() {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1L);     

        Mockito.when(personaRepository.findById(personaPk))
        .thenReturn(Optional.of(new PersonaEntity(personaPk, 12345678L, null, 
                "Juan Tester", LocalDate.of(1990, 4, 4), "test@tester.com", true, null, 
                "2000SC", GeneroEnum.MASCULINO, null)));
        
        PersonaEntity personaEntity = personaService.getById(personaPk);
        
        assertThat(personaEntity.getNumeroDocumento()).isEqualTo(12345678L);
        assertThat(personaEntity.getCodigoPostal()).isEqualTo("2000SC");
        assertThat(personaEntity.getCorreoElectronico()).isEqualTo("test@tester.com");
        assertThat(personaEntity.getFechaNacimiento()).isEqualTo(LocalDate.of(1990, 4, 4));
        assertThat(personaEntity.getEsArgentino()).isEqualTo(true);
        assertThat(personaEntity.getGenero()).isEqualTo(GeneroEnum.MASCULINO);
    }
}
