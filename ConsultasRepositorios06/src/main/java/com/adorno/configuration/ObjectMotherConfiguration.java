package com.adorno.configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adorno.modelo.entities.Socio;

@Configuration
public class ObjectMotherConfiguration {

	//cuando arranque Spring va a crear esta lista y se la puedes pedir,
	//cada vez que se la pidas, en la misma ejecucion, te dara la misma lista
	@Bean
	List<Socio> getSocios() {
		 List<Socio> listaSocios = new ArrayList<>();
		  listaSocios.add(new Socio(true, LocalDate.of(2023, 5, 10), "García", "Martín", 100.0f));
	        listaSocios.add(new Socio(false, LocalDate.of(2022, 8, 25), "López", "Sofía", 150.0f));
	        listaSocios.add(new Socio(true, LocalDate.of(2023, 2, 15), "Fernández", "Alejandro", 200.0f));
	        listaSocios.add(new Socio(false, LocalDate.of(2022, 11, 3), "Rodríguez", "Laura", 120.0f));
	        listaSocios.add(new Socio(true, LocalDate.of(2023, 1, 1), "Gómez", "Pablo", 80.0f));
	        listaSocios.add(new Socio(false, LocalDate.of(2023, 4, 5), "Díaz", "Ana", 130.0f));
	        listaSocios.add(new Socio(true, LocalDate.of(2022, 10, 15), "Martínez", "Carlos", 90.0f));
	        listaSocios.add(new Socio(true, LocalDate.of(2022, 7, 8), "Pérez", "Elena", 110.0f));
	        listaSocios.add(new Socio(false, LocalDate.of(2023, 3, 1), "González", "Javier", 160.0f));
	        listaSocios.add(new Socio(true, LocalDate.of(2022, 12, 10), "Sánchez", "Isabel", 70.0f));
	        listaSocios.add(new Socio(false, LocalDate.of(2023, 6, 18), "Romero", "Francisco", 180.0f));
	        return listaSocios;
	}
}
