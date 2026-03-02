package com.adorno.mappers;

import com.adorno.model.UserEntity;
import com.adorno.model.dtos.UserCreateDTO;
import com.adorno.model.dtos.UserInfoDTO;

public class UserEntity2UserInfoDTOMapper implements MyMapper<UserEntity, UserInfoDTO> {

	@Override
	public UserInfoDTO map(UserEntity t) {
		return new UserInfoDTO(t.getEmail(), t.getUsername());
	}

}
