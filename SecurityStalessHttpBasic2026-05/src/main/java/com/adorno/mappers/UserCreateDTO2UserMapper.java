package com.adorno.mappers;

import com.adorno.model.UserEntity;
import com.adorno.model.dtos.UserCreateDTO;

public class UserCreateDTO2UserMapper implements MyMapper<UserCreateDTO, UserEntity> {

	@Override
	public UserEntity map(UserCreateDTO t) {

		return new UserEntity(t.email(), t.username(), t.password());
	}

}
