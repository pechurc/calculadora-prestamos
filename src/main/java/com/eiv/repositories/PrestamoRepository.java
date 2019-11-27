package com.eiv.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eiv.entities.PrestamoEntity;

public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Long> {

    @Query("SELECT MAX(e.id) FROM PrestamoEntity e")
    public Optional<Long> getMax();
}
