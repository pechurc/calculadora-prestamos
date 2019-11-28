package com.eiv.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
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

import com.eiv.dtos.PrestamoDto;
import com.eiv.entities.PersonaPkEntity;
import com.eiv.entities.PrestamoEntity;
import com.eiv.entities.UsuarioEntity;
import com.eiv.exceptions.NotFoundServiceException;
import com.eiv.repositories.PrestamoRepository;

@RunWith(MockitoJUnitRunner.class)
public class PrestamoServiceTest {

    @Mock
    UsuarioService usuarioService;
    
    @Mock
    PrestamoRepository prestamoRepository;
    
    @InjectMocks
    PrestamoService prestamoService;
    
    @Test
    public void givenPrestamoDto_whenCreate_thenPrestamoEntityCreated() {
        
        PersonaPkEntity personaPk = new PersonaPkEntity(1L, 1L);
        when(usuarioService.getById(personaPk))
        .thenReturn(new UsuarioEntity(personaPk, "test", "test_pwd"));
        when(prestamoRepository.getMax()).thenReturn(Optional.of(0L));
        
        PrestamoEntity prestamoEntity = prestamoService.save(
                new PrestamoDto(1L, 1L, LocalDate.now(), new BigDecimal("1"), new BigDecimal("1"),
                        new BigDecimal("1000"), new BigDecimal("2000")));
        
        assertThat(prestamoEntity.getFechaAlta()).isEqualTo(LocalDate.now());
        assertThat(prestamoEntity.getTea()).isEqualTo(new BigDecimal("1"));
        assertThat(prestamoEntity.getTeaModulo()).isEqualTo(new BigDecimal("1"));
        assertThat(prestamoEntity.getCapitalPrestado()).isEqualTo(new BigDecimal("1000"));
        assertThat(prestamoEntity.getTotalIntereses()).isEqualTo(new BigDecimal("2000"));
    }
    
    @Test
    public void givenPrestamoDto_whenUpdate_thenPrestamoEntityUpdated() {
        
        when(prestamoRepository.findById(1L)).thenReturn(Optional.of(new PrestamoEntity(1L, null, 
                LocalDate.now(), new BigDecimal("1"), new BigDecimal("1"),
                new BigDecimal("1000"), new BigDecimal("2000"))));
        
        PrestamoEntity prestamoEntity = prestamoService.update(1L, 
                new PrestamoDto(1L, 1L, LocalDate.now(), new BigDecimal("2"), new BigDecimal("2"),
                        new BigDecimal("2000"), new BigDecimal("3000")));
        
        assertThat(prestamoEntity.getFechaAlta()).isEqualTo(LocalDate.now());
        assertThat(prestamoEntity.getTea()).isEqualTo(new BigDecimal("2"));
        assertThat(prestamoEntity.getTeaModulo()).isEqualTo(new BigDecimal("2"));
        assertThat(prestamoEntity.getCapitalPrestado()).isEqualTo(new BigDecimal("2000"));
        assertThat(prestamoEntity.getTotalIntereses()).isEqualTo(new BigDecimal("3000"));
    }
    
    @Test
    public void givenPrestamoId_whenDelete_thenPrestamoDeleted() {
        
        PrestamoEntity prestamoEntity = new PrestamoEntity(1L, null, 
                LocalDate.now(), new BigDecimal("1"), new BigDecimal("1"),
                new BigDecimal("1000"), new BigDecimal("2000"));
        
        when(prestamoRepository.findById(1L)).thenReturn(Optional.of(prestamoEntity));
        
        prestamoService.delete(1L);
        
        verify(prestamoRepository).findById(Mockito.eq(1L));
        verify(prestamoRepository).delete(Mockito.eq(prestamoEntity));
    }
    
    @Test
    public void givenPrestamoId_whenDeleteNonExist_thenThrowException() {

        Throwable throwable = catchThrowable(() -> prestamoService.delete(0L));
        
        assertThat(throwable)
                .isInstanceOf(NotFoundServiceException.class)
                .hasMessageContaining("Prestamo con ID=0 no encontrada");

        Mockito.verify(prestamoRepository).findById(Mockito.eq(0L));
        Mockito.verify(prestamoRepository, never()).delete(Mockito.any(PrestamoEntity.class));
    }
    
    @Test
    public void givenPrestamoId_whenGet_thenPrestamoEntityReturned() {
        
        PrestamoEntity prestamoEntity = new PrestamoEntity(1L, null, 
                LocalDate.now(), new BigDecimal("1"), new BigDecimal("1"),
                new BigDecimal("1000"), new BigDecimal("2000"));
        
        when(prestamoRepository.findById(1L)).thenReturn(Optional.of(prestamoEntity));
        
        PrestamoEntity returned = prestamoService.getById(1L);
        
        assertThat(returned).isEqualTo(prestamoEntity);
    }
}
