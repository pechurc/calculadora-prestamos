package com.eiv.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.never;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.eiv.dtos.LocalidadDto;
import com.eiv.entities.LocalidadEntity;
import com.eiv.entities.ProvinciaEntity;
import com.eiv.enums.RegionEnum;
import com.eiv.exceptions.NotFoundServiceException;
import com.eiv.repositories.LocalidadRepository;

@RunWith(MockitoJUnitRunner.class)
public class LocalidadServiceTest {
    
    @Mock 
    ProvinciaService provinciaService;
    
    @Mock     
    LocalidadRepository localidadRepository;
    
    @InjectMocks    
    LocalidadService localidadService;
    
    @Test
    public void givenLocalidadDto_whenCreate_thenLocalidadEntityCreated() {
        
        Mockito.when(provinciaService.getById(1L))
            .thenReturn(new ProvinciaEntity(1L, "ProvinciaTest", RegionEnum.CUYO));
        
        Mockito.when(localidadRepository.getMax()).thenReturn(Optional.of(0L));
        
        LocalidadDto localidad = new LocalidadDto("TEST", "2000", 1L);
        
        LocalidadEntity localidadEntity = localidadService.save(localidad);
        
        assertThat(localidadEntity.getId()).isEqualTo(1);
        assertThat(localidadEntity.getNombre()).isEqualTo("TEST");
        assertThat(localidadEntity.getProvincia().getNombre()).isEqualTo("ProvinciaTest");
    }
    
    @Test
    public void givenLocalidadDto_whenUpdate_thenLocalidadEntityUpdated() {
        
        Mockito.when(provinciaService.getById(1L))
        .thenReturn(new ProvinciaEntity(1L, "ProvinciaTest", RegionEnum.CUYO));
        
        Mockito.when(localidadRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(new LocalidadEntity(0L, "ORIGINAL", "2000",
                        new ProvinciaEntity(1L, "ProvinciaTest", RegionEnum.CUYO))));
        
        LocalidadDto localidad = new LocalidadDto("TEST", "2001", 1L);
        
        LocalidadEntity localidadEntity = localidadService.update(0L, localidad);
        
        assertThat(localidadEntity.getId()).isEqualTo(0L);
        assertThat(localidadEntity.getNombre()).isEqualTo("TEST");
        assertThat(localidadEntity.getProvincia().getNombre()).isEqualTo("ProvinciaTest");
    }
    
    @Test
    public void givenLocalidadDto_whenUpdateNonExist_thenThrowException() {
        
        LocalidadDto localidad = new LocalidadDto("TEST", "2000", 1L);
        
        Throwable throwable = catchThrowable(() -> localidadService.update(0L, localidad));

        assertThat(throwable)
        .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("Localidad con ID=0 no encontrada");
    }
    
    @Test
    public void givenProvinciaId_thenDelete() {

        LocalidadEntity localidadEntity = new LocalidadEntity(0L, "TEST", "2000",
                new ProvinciaEntity(1L, "ProvinciaTest", RegionEnum.CUYO));
        
        Mockito.when(localidadRepository
                .findById(Mockito.eq(0L)))
                .thenReturn(Optional.of(localidadEntity));
        
        localidadService.delete(0L);
        
        Mockito.verify(localidadRepository).findById(Mockito.eq(0L));
        Mockito.verify(localidadRepository).delete(Mockito.eq(localidadEntity));
    }

    @Test
    public void givenProvinciaId_whenDeleteNonExist_thenThrowException() {

        Throwable throwable = catchThrowable(() -> localidadService.delete(0L));
        
        assertThat(throwable)
                .isInstanceOf(NotFoundServiceException.class)
                .hasMessageContaining("Localidad con ID=0 no encontrada");

        Mockito.verify(localidadRepository).findById(Mockito.eq(0L));
        Mockito.verify(localidadRepository, never()).delete(Mockito.any(LocalidadEntity.class));
    }
    
    @Test
    public void givenLocalidadId_whenExists_thenReturnLocalidadEntity() {
        
        Mockito.when(localidadRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(new LocalidadEntity(0L, "ORIGINAL", "2000",
                        new ProvinciaEntity(1L, "ProvinciaTest", RegionEnum.CUYO))));
        
        LocalidadEntity localidadEntity = localidadService.getById(1L);
        
        assertThat(localidadEntity.getId()).isEqualTo(0L);
        assertThat(localidadEntity.getNombre()).isEqualTo("ORIGINAL");
        assertThat(localidadEntity.getProvincia().getNombre()).isEqualTo("ProvinciaTest");
    }
    
    @Test
    public void givenLocalidadId_whenNonExists_thenThrowNotFoundServiceException() {

        Throwable throwable = catchThrowable(() -> localidadService.getById(0L));
        
        assertThat(throwable)
                .isInstanceOf(NotFoundServiceException.class)
                .hasMessageContaining("Localidad con ID=0 no encontrada");

        Mockito.verify(localidadRepository).findById(Mockito.eq(0L));
    }
}
