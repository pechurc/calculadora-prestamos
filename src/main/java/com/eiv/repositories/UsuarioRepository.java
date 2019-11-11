package com.eiv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiv.entities.UsuarioEntity;
import com.eiv.entities.UsuarioPkEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UsuarioPkEntity> {

}
