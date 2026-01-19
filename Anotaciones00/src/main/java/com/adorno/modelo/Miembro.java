package com.adorno.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;

@Entity
//para expresar que una tabla existente va a ser utilizada
@SecondaryTable(name = "otra", pkJoinColumns = @PrimaryKeyJoinColumn(name = "miembro_id"))
public class Miembro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "mi_socio", length = 12)
	private String nombre;
	//por bbdd legacy este dato esta en otra tabla
	@Column(table = "otra")
	private int otraTabla = 8;
}
