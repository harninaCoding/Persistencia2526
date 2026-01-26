package com.adorno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	public List<Pedido> findByPersona(Persona persona);

}
