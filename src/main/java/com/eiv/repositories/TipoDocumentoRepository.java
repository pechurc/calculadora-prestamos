package com.eiv.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.entities.TipoDocumentoEntity;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Long>, QuerydslPredicateExecutor<TipoDocumentoEntity> {

    @Query("SELECT MAX(e.id) FROM TipoDocumentoEntity e")
    public Optional<Long> getMax();
}
