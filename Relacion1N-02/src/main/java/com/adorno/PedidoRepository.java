package com.adorno;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long> {
//	public List<Pedido> findByPersona(Persona persona);

}
