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

import com.eiv.dtos.PrestamoCuotaDto;
import com.eiv.entities.PrestamoCuotaEntity;
import com.eiv.entities.PrestamoCuotaPk;
import com.eiv.entities.PrestamoEntity;
import com.eiv.exceptions.NotFoundServiceException;
import com.eiv.repositories.PrestamoCuotaRepository;

@RunWith(MockitoJUnitRunner.class)
public class PrestamoCuotaServiceTest {

    @Mock
    PrestamoCuotaRepository prestamoCuotaRepository;
    
    @Mock
    PrestamoService prestamoService;
    
    @InjectMocks
    PrestamoCuotaService prestamoCuotaService;
    
    @Test
    public void givenPrestamoCuotaDto_whenCreate_thenPrestamoCuotaEntityCreated() {

        when(prestamoService.getById(1L)).thenReturn(new PrestamoEntity(1L, null, 
                LocalDate.now(), new BigDecimal("1"), new BigDecimal("1"),
                new BigDecimal("1000"), new BigDecimal("2000")));
        
        PrestamoCuotaEntity prestamoCuotaEntity = prestamoCuotaService.save(
                new PrestamoCuotaDto(1L, 1, new BigDecimal("100"), new BigDecimal("100"), 
                        new BigDecimal("200")));
        
        assertThat(prestamoCuotaEntity.getImporteCapital()).isEqualTo(new BigDecimal("100"));
        assertThat(prestamoCuotaEntity.getImporteIntereses()).isEqualTo(new BigDecimal("100"));
        assertThat(prestamoCuotaEntity.getImporteTotal()).isEqualTo(new BigDecimal("200"));
        assertThat(prestamoCuotaEntity.getNroCuota()).isEqualTo(1);
        assertThat(prestamoCuotaEntity.getPrestamo().getId()).isEqualTo(1L);
    }
    
    @Test
    public void givenPrestamoCuotaDto_whenUpdate_thenPrestamoCuotaEntityUpdated() {

        PrestamoCuotaPk pk = new PrestamoCuotaPk(1, 1);
        when(prestamoCuotaRepository.findById(pk))
        .thenReturn(Optional.of(new PrestamoCuotaEntity(pk, null, 1, new BigDecimal("100"), 
                new BigDecimal("100"), new BigDecimal("200"))));
        
        PrestamoCuotaEntity prestamoCuotaEntity = prestamoCuotaService.update(pk, 
                new PrestamoCuotaDto(1L, 1, new BigDecimal("200"), new BigDecimal("200"), 
                        new BigDecimal("400")));
        
        assertThat(prestamoCuotaEntity.getImporteCapital()).isEqualTo(new BigDecimal("200"));
        assertThat(prestamoCuotaEntity.getImporteIntereses()).isEqualTo(new BigDecimal("200"));
        assertThat(prestamoCuotaEntity.getImporteTotal()).isEqualTo(new BigDecimal("400"));
        assertThat(prestamoCuotaEntity.getNroCuota()).isEqualTo(1);
    }

    @Test
    public void givenPrestamoCuotaId_whenDelete_thenPrestamoCuotaDeleted() {
        
        PrestamoCuotaPk pk = new PrestamoCuotaPk(1, 1);
        PrestamoCuotaEntity prestamoCuotaEntity = new PrestamoCuotaEntity(pk, null, 1, 
                new BigDecimal("100"), new BigDecimal("100"), new BigDecimal("200"));
        when(prestamoCuotaRepository.findById(pk))
        .thenReturn(Optional.of(prestamoCuotaEntity));
        
        prestamoCuotaService.delete(pk);
        
        Mockito.verify(prestamoCuotaRepository).findById(Mockito.eq(pk));
        Mockito.verify(prestamoCuotaRepository).delete(Mockito.eq(prestamoCuotaEntity));
    }
    

    @Test
    public void givenPrestamoCuotaId_whenDeleteNonExist_thenThrowException() {

        PrestamoCuotaPk pk = new PrestamoCuotaPk(1, 1);
        Throwable throwable = catchThrowable(() -> prestamoCuotaService.delete(pk));
        
        assertThat(throwable)
                .isInstanceOf(NotFoundServiceException.class)
                .hasMessageContaining("Cuota con ID=PrestamoCuotaPk [prestamo=1, nroCuota=1] "
                        + "no encontrada");

        Mockito.verify(prestamoCuotaRepository).findById(Mockito.eq(pk));
        Mockito.verify(prestamoCuotaRepository, never())
        .delete(Mockito.any(PrestamoCuotaEntity.class));
    }
    
    @Test
    public void givenPrestamoCuotaId_whenGet_thenPrestamoCuotaReturned() {
        
        PrestamoCuotaPk pk = new PrestamoCuotaPk(1, 1);
        PrestamoCuotaEntity prestamoCuotaEntity = new PrestamoCuotaEntity(pk, null, 1, 
                new BigDecimal("100"), new BigDecimal("100"), new BigDecimal("200"));
        when(prestamoCuotaRepository.findById(pk))
        .thenReturn(Optional.of(prestamoCuotaEntity));
        
        PrestamoCuotaEntity returned = prestamoCuotaService.getById(pk);
        
        assertThat(prestamoCuotaEntity).isEqualTo(returned);
    }
}
