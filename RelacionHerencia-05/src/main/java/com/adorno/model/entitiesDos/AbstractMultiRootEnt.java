package com.adorno.model.entitiesDos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@ToString
public abstract class AbstractMultiRootEnt {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NonNull
	private String name;
	
}
