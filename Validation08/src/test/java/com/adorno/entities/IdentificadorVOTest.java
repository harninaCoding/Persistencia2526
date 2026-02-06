package com.adorno.entities;

import static org.assertj.core.api.Assertions.fail;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

class IdentificadorVOTest {

	@Test
	void test() {
		List<String> mal = List.of("AAAAA","44444DD","4444444","AA00119");
		List<String> bien = List.of("AA12345","BN98765","CC76543","AA00120");
		for (int i = 0; i < mal.size(); i++) {
			try {
				IdentificadorVO identificadorVO=new IdentificadorVO(mal.get(i));
				//el fallo, para nosotros, es que crease el objeto
				fail();
			} catch (Exception e) {
			}
			IdentificadorVO identificadorVO=new IdentificadorVO(bien.get(i));
		}
		
	}

}
