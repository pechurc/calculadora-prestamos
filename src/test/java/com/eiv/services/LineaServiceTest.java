package com.eiv.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.eiv.dtos.LineaDto;
import com.eiv.entities.LineaEntity;
import com.eiv.entities.PersonaEntity;
import com.eiv.entities.PersonaPkEntity;
import com.eiv.entities.UsuarioEntity;
import com.eiv.enums.GeneroEnum;
import com.eiv.enums.SistemaAmortizacionEnum;
import com.eiv.exceptions.NotFoundServiceException;
import com.eiv.repositories.LineaRepository;

@RunWith(MockitoJUnitRunner.class)
public class LineaServiceTest {
    
    @Mock
    UsuarioService usuarioService;
    
    @Mock
    LineaRepository lineaRepository;
    
    @InjectMocks
    LineaService lineaService;
    
    @Test
    public void givenLineaDto_whenCreate_thenLineaEntityCreated() {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1);      
        PersonaEntity personaEntity = new PersonaEntity(personaPk, 12345678L, null, 
                "Juan Tester", LocalDate.of(1990, 4, 4), "test@tester.com", true, null, 
                "2000SC", GeneroEnum.MASCULINO, null);
        UsuarioEntity usuarioEntity = new UsuarioEntity(personaEntity, "juantes", "asdqwe");
        
        when(usuarioService.getById(personaPk))
        .thenReturn(usuarioEntity);
        when(lineaRepository.getMax()).thenReturn(Optional.of(0));
        
        LineaEntity lineaEntity = lineaService.save(new LineaDto(12345678L, 1, "TEST!", 
                BigDecimal.valueOf(1.1f), BigDecimal.valueOf(1.2f), 1, 12, 
                BigDecimal.valueOf(100d), BigDecimal.valueOf(1000d), LocalDate.of(2019, 11, 27), 
                SistemaAmortizacionEnum.AMERICANO));
        
        
        assertThat(lineaEntity.getId()).isEqualTo(1);
        assertThat(lineaEntity.getUsuario()).isEqualTo(usuarioEntity);
        assertThat(lineaEntity.getTasaMin()).isEqualTo(BigDecimal.valueOf(1.1f));
        assertThat(lineaEntity.getTasaMax()).isEqualTo(BigDecimal.valueOf(1.2f));
        assertThat(lineaEntity.getCapitalMin()).isEqualTo(BigDecimal.valueOf(100d));
        assertThat(lineaEntity.getCapitalMax()).isEqualTo(BigDecimal.valueOf(1000d));
        assertThat(lineaEntity.getCuotasMin()).isEqualTo(1);
        assertThat(lineaEntity.getCuotasMax()).isEqualTo(12);
        assertThat(lineaEntity.getSistemaAmortizacion())
        .isEqualTo(SistemaAmortizacionEnum.AMERICANO);
        assertThat(lineaEntity.getFechaAlta()).isEqualTo(LocalDate.of(2019, 11, 27));
        
    }
    
    @Test
    public void givenLineaDto_whenUpdate_thenLineaEntityUpdated() {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(12345678L, 1);      
        PersonaEntity personaEntity = new PersonaEntity(personaPk, 12345678L, null, 
                "Juan Tester", LocalDate.of(1990, 4, 4), "test@tester.com", true, null, 
                "2000SC", GeneroEnum.MASCULINO, null);
        UsuarioEntity usuarioEntity = new UsuarioEntity(personaEntity, "juantes", "asdqwe");

        when(lineaRepository.findById(1)).thenReturn(Optional.of(new LineaEntity(1, usuarioEntity,
                "TEST!",  BigDecimal.valueOf(1.1f), BigDecimal.valueOf(1.2f), 1, 12, 
                BigDecimal.valueOf(100d), BigDecimal.valueOf(1000d), LocalDate.of(2019, 11, 27), 
                SistemaAmortizacionEnum.AMERICANO)));
        
        LineaEntity lineaEntity = lineaService.update(1, new LineaDto(12345678L, 1, "TEST!", 
                BigDecimal.valueOf(1.3f), BigDecimal.valueOf(1.4f), 1, 12, 
                BigDecimal.valueOf(101d), BigDecimal.valueOf(1001d), LocalDate.of(2019, 11, 27), 
                SistemaAmortizacionEnum.FRANCES));
        
        
        assertThat(lineaEntity.getUsuario()).isEqualTo(usuarioEntity);
        assertThat(lineaEntity.getTasaMin()).isEqualTo(BigDecimal.valueOf(1.3f));
        assertThat(lineaEntity.getTasaMax()).isEqualTo(BigDecimal.valueOf(1.4f));
        assertThat(lineaEntity.getCapitalMin()).isEqualTo(BigDecimal.valueOf(101d));
        assertThat(lineaEntity.getCapitalMax()).isEqualTo(BigDecimal.valueOf(1001d));
        assertThat(lineaEntity.getCuotasMin()).isEqualTo(1);
        assertThat(lineaEntity.getCuotasMax()).isEqualTo(12);
        assertThat(lineaEntity.getSistemaAmortizacion())
        .isEqualTo(SistemaAmortizacionEnum.FRANCES);
        assertThat(lineaEntity.getFechaAlta()).isEqualTo(LocalDate.of(2019, 11, 27));
        
    }

    @Test
    public void givenLineaDto_whenUpdateNonExists_thenThrowNotFoundServiceException() {
        
        LineaDto lineaDto = new LineaDto(12345678L, 1, "TEST!", 
                BigDecimal.valueOf(1.3f), BigDecimal.valueOf(1.4f), 1, 12, 
                BigDecimal.valueOf(101d), BigDecimal.valueOf(1001d), LocalDate.of(2019, 11, 27), 
                SistemaAmortizacionEnum.FRANCES);

        Throwable throwable = catchThrowable(() -> lineaService.update(1, lineaDto));
        
        assertThat(throwable)
        .isInstanceOf(NotFoundServiceException.class)
            .hasMessageContaining("Linea con ID=1 no encontrada");
    }
    
    @Test
    public void givenId_thenDelete() {
        
        LineaEntity lineaEntity = new LineaEntity(1, null, 
                "TEST!",  BigDecimal.valueOf(1.1f), BigDecimal.valueOf(1.2f), 1, 12, 
                BigDecimal.valueOf(100d), BigDecimal.valueOf(1000d), LocalDate.of(2019, 11, 27), 
                SistemaAmortizacionEnum.AMERICANO);
        
        when(lineaRepository.findById(1)).thenReturn(Optional.of(lineaEntity));        
        
        lineaService.delete(1);
        
        Mockito.verify(lineaRepository).findById(Mockito.eq(1));
        Mockito.verify(lineaRepository).delete(Mockito.eq(lineaEntity));        
    }
    
    @Test
    public void givenProvinciaId_whenDeleteNonExist_thenThrowException() {

        Throwable throwable = catchThrowable(() -> lineaService.delete(1));
        
        assertThat(throwable)
                .isInstanceOf(NotFoundServiceException.class)
                .hasMessageContaining("Linea con ID=1 no encontrada");

        Mockito.verify(lineaRepository).findById(Mockito.eq(1));
        Mockito.verify(lineaRepository, never()).delete(Mockito.any(LineaEntity.class));
    }
}
