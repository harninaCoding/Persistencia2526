package com.adorno.populaters;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adorno.model.ERole;
import com.adorno.model.RoleEntity;
import com.adorno.model.UserEntity;
import com.adorno.repositories.RoleRepository;
import com.adorno.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class CreatingGod {

    private final RolePopulates rolePopulates;
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

    CreatingGod(RolePopulates rolePopulates) {
        this.rolePopulates = rolePopulates;
    }

    //Se ejecuta despues de la creacion de los repos
    @PostConstruct
    public void init() throws Exception {
        if (userRepository.count() == 0) {
            UserEntity admin = new UserEntity();
            admin.setUsername("Dios");
            admin.setEmail("yo@yo.es");
            admin.setPassword("123AAA.www4"); // Tu PlainTextPasswordEncoder lo entenderá
            // Asigna los roles necesarios aquí
			Optional<RoleEntity> byName = roleRepository.findByName(ERole.GUEST);
			admin.setRoles(Set.of(byName.get()));
            userRepository.save(admin);
        }
    }
}
