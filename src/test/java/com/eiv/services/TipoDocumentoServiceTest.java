package com.eiv.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.eiv.dtos.TipoDocumentoDto;
import com.eiv.entities.TipoDocumentoEntity;
import com.eiv.exceptions.NotFoundServiceException;
import com.eiv.repositories.TipoDocumentoRepository;

@RunWith(MockitoJUnitRunner.class)
public class TipoDocumentoServiceTest {

    @Mock
    TipoDocumentoRepository tipoDocumentoRepository;
    
    @InjectMocks
    TipoDocumentoService tipoDocumentoService;
    
    
    @Test
    public void givenTipoDocumentoDto_whenCreate_thenTipoDocumentoEntityCreated() {
        
        when(tipoDocumentoRepository.getMax()).thenReturn(Optional.of(0L));
        
        TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto("DNI", "DNI", true);
        
        TipoDocumentoEntity tipoDocumentoEntity= tipoDocumentoService.save(tipoDocumentoDto);
        
        assertThat(tipoDocumentoEntity.getId()).isEqualTo(1);
        assertThat(tipoDocumentoEntity.getAbreviatura()).isEqualTo("DNI");
        assertThat(tipoDocumentoEntity.getNombre()).isEqualTo("DNI");
        assertThat(tipoDocumentoEntity.getValidarComoCuit()).isEqualTo(true);
    }
    
    @Test
    public void givenTipoDocumentoDto_whenUpdate_thenTipoDocumentoEntityUpdated() {
        
        when(tipoDocumentoRepository.findById(1L))
        .thenReturn(Optional.of(new TipoDocumentoEntity(1L, "DNI", "DNI", false)));
        
        TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto("DocNacId", "DNI2", true);
        
        TipoDocumentoEntity tipoDocumentoEntity= tipoDocumentoService.update(1L, tipoDocumentoDto);
        
        assertThat(tipoDocumentoEntity.getId()).isEqualTo(1);
        assertThat(tipoDocumentoEntity.getAbreviatura()).isEqualTo("DNI2");
        assertThat(tipoDocumentoEntity.getNombre()).isEqualTo("DocNacId");
        assertThat(tipoDocumentoEntity.getValidarComoCuit()).isEqualTo(true);
    }
    
    @Test 
    public void givenTipoDocumentoDto_whenUpdateNonExists_thenThrowNotFoundServiceException() {
        
        TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto("DNI", "DNI", true);
        
        Throwable throwable = catchThrowable(
                () -> tipoDocumentoService.update(1L, tipoDocumentoDto));
        
        assertThat(throwable)
        .isInstanceOf(NotFoundServiceException.class)
            .hasMessageContaining("Tipo documento con ID=1 no encontrada");
    }
    
    @Test
    public void givenId_whenDelete_thenDeleted() {
        
        TipoDocumentoEntity tipoDocumentoEntity = new TipoDocumentoEntity(1L, "DNI", "DNI", false);
        
        when(tipoDocumentoRepository.findById(1L))
        .thenReturn(Optional.of(new TipoDocumentoEntity(1L, "DNI", "DNI", false)));

        tipoDocumentoService.delete(1L);
        
        Mockito.verify(tipoDocumentoRepository).findById(Mockito.eq(1L));
        Mockito.verify(tipoDocumentoRepository).delete(Mockito.eq(tipoDocumentoEntity));
    }
    
    @Test
    public void givenId_whenDeleteNonExists_thenThrowNotFoundServiceException() {
                
        Throwable throwable = catchThrowable(
                () -> tipoDocumentoService.delete(1L));
                
        assertThat(throwable)
        .isInstanceOf(NotFoundServiceException.class)
        .hasMessageContaining("Tipo documento con ID=1 no encontrada");
        
        Mockito.verify(tipoDocumentoRepository).findById(Mockito.eq(1L));
        Mockito.verify(tipoDocumentoRepository, never())
        .delete(Mockito.any(TipoDocumentoEntity.class));
    }
    
    @Test
    public void givenTipoDocumentoId_whenExists_thenReturnLocalidadEntity() {
        
        when(tipoDocumentoRepository.findById(1L))
        .thenReturn(Optional.of(new TipoDocumentoEntity(1L, "DNI", "DNI", false)));
        
        TipoDocumentoEntity tipoDocumentoEntity = tipoDocumentoService.getById(1L);
        
        assertThat(tipoDocumentoEntity.getId()).isEqualTo(1L);
        assertThat(tipoDocumentoEntity.getNombre()).isEqualTo("DNI");
        assertThat(tipoDocumentoEntity.getAbreviatura()).isEqualTo("DNI");
    }
}
