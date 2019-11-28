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

import com.eiv.dtos.ProvinciaDto;
import com.eiv.entities.ProvinciaEntity;
import com.eiv.enums.RegionEnum;
import com.eiv.exceptions.NotFoundServiceException;
import com.eiv.repositories.ProvinciaRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProvinciaServiceTest {

    @Mock
    ProvinciaRepository provinciaRepository;

    @InjectMocks
    ProvinciaService provinciaService;

    @Test
    public void givenProvinciaDto_whenCreate_thenProvinciaEntityCreated() {
        
        Mockito.when(provinciaRepository.getMax()).thenReturn(Optional.of(0L));
        
        ProvinciaDto provincia = new ProvinciaDto("TEST", RegionEnum.PAMPEANA);
        
        ProvinciaEntity provinciaEntity = provinciaService.save(provincia);
        
        assertThat(provinciaEntity.getId()).isEqualTo(1L);
        assertThat(provinciaEntity.getNombre()).isEqualTo("TEST");
    }
    
    @Test
    public void givenProvinciaDto_whenUpdate_thenProvinciaEntityUpdated() {
        
        Mockito.when(provinciaRepository
                .findById(Mockito.anyLong()))
                .thenReturn(Optional.of(new ProvinciaEntity(0L, "ORIGINAL", RegionEnum.CUYO)));
        
        ProvinciaDto provincia = new ProvinciaDto("TEST", RegionEnum.NOROESTE);
        
        ProvinciaEntity provinciaEntity = provinciaService.update(0L, provincia);

        assertThat(provinciaEntity.getId()).isEqualTo(0L);
        assertThat(provinciaEntity.getNombre()).isEqualTo("TEST");
    }
    
    @Test
    public void givenProvinciaDto_whenUpdateNonExist_thenThrowException() {
        
        ProvinciaDto provincia = new ProvinciaDto("TEST", RegionEnum.NOROESTE);
        
        Throwable throwable = catchThrowable(() -> provinciaService.update(0L, provincia));

        assertThat(throwable)
        .isInstanceOf(NotFoundServiceException.class)
            .hasMessageContaining("Provincia con ID=0 no encontrada");
    }

    @Test
    public void givenProvinciaId_thenDelete() {

        ProvinciaEntity provinciaEntity = new ProvinciaEntity(0L, "TEST", RegionEnum.NOROESTE);
        
        Mockito.when(provinciaRepository
                .findById(Mockito.eq(0L)))
                .thenReturn(Optional.of(provinciaEntity));
        
        provinciaService.delete(0L);
        
        Mockito.verify(provinciaRepository).findById(Mockito.eq(0L));
        Mockito.verify(provinciaRepository).delete(Mockito.eq(provinciaEntity));
    }

    @Test
    public void givenProvinciaId_whenDeleteNonExist_thenThrowException() {

        Throwable throwable = catchThrowable(() -> provinciaService.delete(0L));
        
        assertThat(throwable)
                .isInstanceOf(NotFoundServiceException.class)
                .hasMessageContaining("Provincia con ID=0 no encontrada");

        Mockito.verify(provinciaRepository).findById(Mockito.eq(0L));
        Mockito.verify(provinciaRepository, never()).delete(Mockito.any(ProvinciaEntity.class));
    }
    
    @Test
    public void givenProvinciaId_whenExists_thenReturnProvinciaEntity() {

        Mockito.when(provinciaRepository
                .findById(Mockito.eq(0L)))
                .thenReturn(Optional.of(new ProvinciaEntity(0L, "TEST", RegionEnum.NOROESTE)));
        
        ProvinciaEntity provinciaEntity = provinciaService.getById(0L);
        
        assertThat(provinciaEntity.getId()).isEqualTo(0L);
        assertThat(provinciaEntity.getNombre()).isEqualTo("TEST");
        assertThat(provinciaEntity.getRegion()).isEqualTo(RegionEnum.NOROESTE);
    }
    
    @Test
    public void givenProvinciaId_whenNonExists_thenThrowNotFoundServiceException() {

        Throwable throwable = catchThrowable(() -> provinciaService.getById(0L));
        
        assertThat(throwable)
                .isInstanceOf(NotFoundServiceException.class)
                .hasMessageContaining("Provincia con ID=0 no encontrada");

        Mockito.verify(provinciaRepository).findById(Mockito.eq(0L));
    }
}
