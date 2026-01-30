package com.adorno.model.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.model.entities.ConcreteEntity;

@Repository
public interface ConcreteEntityRepository extends JpaRepository<ConcreteEntity, Long> {

}
