package com.eiv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eiv.entities.PrestamoCuotaEntity;
import com.eiv.entities.PrestamoCuotaPk;

public interface PrestamoCuotaRepository extends 
        JpaRepository<PrestamoCuotaEntity, PrestamoCuotaPk>, QuerydslPredicateExecutor<PrestamoCuotaEntity> {

}
