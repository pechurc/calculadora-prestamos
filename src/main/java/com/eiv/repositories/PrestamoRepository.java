package com.eiv.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.entities.PrestamoEntity;

public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Long>, QuerydslPredicateExecutor<PrestamoEntity> {

    @Query("SELECT MAX(e.id) FROM PrestamoEntity e")
    public Optional<Long> getMax();
}
