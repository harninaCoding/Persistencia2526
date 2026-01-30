package com.adorno;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.model.entitiesDos.ConcreteOneMulti;
import com.adorno.model.repos.ConcreteOneMultiRepository;

@SpringBootTest
class OtherConcreteEntityTest {
	@Autowired
	ConcreteOneMultiRepository concreteOneMultiRepository;
	
	@Test
	void test() {
		ConcreteOneMulti concreteEntity=ConcreteOneMulti.builder().name("luis").descripcion("eluno").build();
		System.out.println(concreteEntity.toString());
		concreteOneMultiRepository.save(concreteEntity);
	}

}
