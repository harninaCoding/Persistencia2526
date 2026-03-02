package com.adorno.populaters;

import org.springframework.stereotype.Component;

import com.adorno.model.ERole;
import com.adorno.model.RoleEntity;
import com.adorno.repositories.RoleRepository;

@Component
public class RolePopulates {
	private final RoleRepository roleRepository;

	public RolePopulates(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
		populateRoles();
	}

	public void populateRoles() {
		for (ERole erole : ERole.values()) {
			if (roleRepository.findByName(erole).isEmpty())
				roleRepository.save(new RoleEntity(erole));
		}
	}
}
