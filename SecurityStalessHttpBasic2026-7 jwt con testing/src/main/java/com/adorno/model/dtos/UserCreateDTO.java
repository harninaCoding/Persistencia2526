package com.adorno.model.dtos;

public record UserCreateDTO(String email, String username, String password,String... roles) {
}
