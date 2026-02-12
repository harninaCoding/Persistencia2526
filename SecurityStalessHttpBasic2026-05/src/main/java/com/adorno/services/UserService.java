package com.adorno.services;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.adorno.mappers.UserCreateDTO2UserMapper;
import com.adorno.model.ERole;
import com.adorno.model.RoleEntity;
import com.adorno.model.UserEntity;
import com.adorno.model.dtos.UserCreateDTO;
import com.adorno.repositories.RoleRepository;
import com.adorno.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final UserCreateDTO2UserMapper userCreateDTO2UserMapper;

	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			UserCreateDTO2UserMapper userCreateDTO2UserMapper) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userCreateDTO2UserMapper = userCreateDTO2UserMapper;
	}

	// igual es momento de usar Response
	public boolean createUser(UserCreateDTO userCreateDTO) {
		UserEntity map = userCreateDTO2UserMapper.map(userCreateDTO);
		if (userCreateDTO.roles() != null) {
			Set<RoleEntity> roles = fillRoles(userCreateDTO.roles());
			map.setRoles(roles);
		}
		if (userRepository.save(map) != null) {
			return true;
		}
		return false;
	}

	private Set<RoleEntity> fillRoles(String[] t) {
		if (ERole.validate(t)) {
			return Arrays.asList(t).stream().map((rol) -> {
				ERole rolresult = ERole.getRole(rol).get();
				Optional<RoleEntity> byName = roleRepository.findByName(rolresult);
				RoleEntity roleEntity = byName.get();
				return roleEntity;
			}).collect(Collectors.toSet());
		}
		return null;
	}

	public boolean delete(String username) {
		Optional<UserEntity> byUsername = userRepository.findByUsername(username);
		userRepository.delete(byUsername.get());
//		userRepository.deleteByUsername(username);
		return true;
	}
}
