package com.adorno;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.model.entities.ConcreteEntity;
import com.adorno.model.repos.ConcreteEntityRepository;
import com.adorno.model.repos.OtherConcreteEntityRepository;

@SpringBootTest
class OtherConcreteEntityTest {

	@Autowired
	ConcreteEntityRepository concreteEntityRepository;
	@Autowired
	OtherConcreteEntityRepository otherConcreteEntityRepository;
	
	@Test
	void test() {
		ConcreteEntity concreteEntity=new ConcreteEntity("chopsuey", "uno cualquiera","paso");
		//persistirla DAO/DTO
		ConcreteEntity save = concreteEntityRepository.save(concreteEntity);
	}

}
