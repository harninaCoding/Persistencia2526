package com.adorno.modelo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adorno.modelo.entities.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long> {
	public List<Socio> findAllBySaldoGreaterThan(float saldo);
	public List<Socio> findAllBySaldoLessThanEqual(float saldo);
	public List<Socio> findAllBySaldoLessThanAndNombreStartingWith(float saldo,String start);
	public Optional<Socio> findFirstByApellidosEndingWith(String ending);
	
	//Query
	@Query("Select p From Socio p where Lower(p.apellidos) like 's%'")
	public List<Socio> findQueryOne();
	@Query("Select p From Socio p where p.apellidos like :starting%")
	public List<Socio> findAllByApellidosStartingWith(String starting);
	@Query("select p from Socio p where p.saldo>:saldo and p.apellidos like %:ending")
	public List<Socio> findAllBySaldoGreaterThanAndApellidosEndingWith(@Param("saldo") float saldo,@Param("ending") String ending); 
	@Query("select p from Socio p where p.saldo<=:saldo or p.apellidos not like %:ending")
	public List<Socio> findFacingAllBySaldoGreaterThanAndApellidosEndingWith(@Param("saldo") float saldo,@Param("ending") String ending); 
}
