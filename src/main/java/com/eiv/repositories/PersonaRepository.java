package com.eiv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiv.entities.PersonaEntity;
import com.eiv.entities.PersonaPk;

public interface PersonaRepository extends JpaRepository<PersonaEntity, PersonaPk> {

}
