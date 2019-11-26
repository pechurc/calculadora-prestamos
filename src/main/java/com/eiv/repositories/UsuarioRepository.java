package com.eiv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiv.entities.PersonaPkEntity;
import com.eiv.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, PersonaPkEntity> {

}
