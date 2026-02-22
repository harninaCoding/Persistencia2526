package com.adorno.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class CustomerController {

//	Aqui aplicamos la seguridad
	@GetMapping("index")
	public String index() {
		return "hello secured";
	}
	
//	aqui no seguridad
	@GetMapping("index2")
	public String index2() {
		return "hello unsecured";
	}
	
}
