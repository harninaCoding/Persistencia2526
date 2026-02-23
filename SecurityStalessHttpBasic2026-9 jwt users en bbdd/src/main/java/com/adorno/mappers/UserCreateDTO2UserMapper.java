package com.adorno.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.adorno.model.UserEntity;
import com.adorno.model.dtos.UserCreateDTO;

public class UserCreateDTO2UserMapper implements MyMapper<UserCreateDTO, UserEntity> {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserEntity map(UserCreateDTO t) {

		return new UserEntity(t.email(), t.username(),passwordEncoder.encode(t.password()));
	}

}
