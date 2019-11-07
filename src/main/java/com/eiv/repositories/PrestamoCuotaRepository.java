package com.eiv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiv.entities.PrestamoCuotaEntity;
import com.eiv.entities.PrestamoCuotaPk;

public interface PrestamoCuotaRepository extends 
        JpaRepository<PrestamoCuotaEntity, PrestamoCuotaPk> {

}
