package com.adorno.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adorno.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByUsername(String username);

	void deleteByUsername(String username);
//	ByUsername(String username);
	
	//opcionalmente con query
//	@Query("select u from UserEntity u where u.username=?1")
//	Optional<UserEntity> getName(String username);
}
