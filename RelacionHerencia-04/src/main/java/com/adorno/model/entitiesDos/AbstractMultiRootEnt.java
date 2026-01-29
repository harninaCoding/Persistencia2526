package com.adorno.model.entitiesDos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractMultiRootEnt {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
}
