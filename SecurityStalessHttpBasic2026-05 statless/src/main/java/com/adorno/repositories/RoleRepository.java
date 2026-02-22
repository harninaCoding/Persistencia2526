package com.adorno.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adorno.model.ERole;
import com.adorno.model.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	public Optional<RoleEntity> findByName(ERole erole);
}
