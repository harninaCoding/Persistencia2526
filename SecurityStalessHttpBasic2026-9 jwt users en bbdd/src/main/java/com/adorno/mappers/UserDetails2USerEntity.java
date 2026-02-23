package com.adorno.mappers;

import org.springframework.security.core.userdetails.UserDetails;

import com.adorno.model.UserEntity;

public class UserDetails2USerEntity implements MyMapper<UserDetails, UserEntity>{

	@Override
	public UserEntity map(UserDetails t) {
		return new UserEntity("uno@uno.es", t.getUsername(), t.getPassword());
	}

}
