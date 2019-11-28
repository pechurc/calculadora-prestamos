package com.eiv.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eiv.entities.LineaEntity;

public interface LineaRepository extends JpaRepository<LineaEntity, Long> {

    @Query("SELECT MAX(e.id) FROM LineaEntity e")
    public Optional<Long> getMax();
}
