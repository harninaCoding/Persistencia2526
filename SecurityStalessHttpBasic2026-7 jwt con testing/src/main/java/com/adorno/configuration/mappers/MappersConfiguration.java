package com.adorno.configuration.mappers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adorno.mappers.UserCreateDTO2UserMapper;
import com.adorno.mappers.UserEntity2UserInfoDTOMapper;

@Configuration
public class MappersConfiguration {

	@Bean
	public UserCreateDTO2UserMapper getCreateDTO2UserMapper() {
		return new UserCreateDTO2UserMapper();
	}
	
	@Bean
	public UserEntity2UserInfoDTOMapper getEntity2UserInfoDTOMapper() {
		return new UserEntity2UserInfoDTOMapper();
	}

}
