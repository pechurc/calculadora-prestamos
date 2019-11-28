package com.eiv.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eiv.entities.TipoDocumentoEntity;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Long> {

    @Query("SELECT MAX(e.id) FROM TipoDocumentoEntity e")
    public Optional<Long> getMax();
}
