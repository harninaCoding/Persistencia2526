package com.adorno.model.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.model.entities.OtherConcreteEntity;

@Repository
public interface OtherConcreteEntityRepository extends JpaRepository<OtherConcreteEntity, Long> {

}
