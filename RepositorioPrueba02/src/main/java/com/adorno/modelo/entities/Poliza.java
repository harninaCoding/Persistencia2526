package com.adorno.modelo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Embeddable;


@Embeddable
public class Poliza implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idPol;
	
	private LocalDate inicio;
	
	public Poliza(long id,LocalDate inicio) {
		super();
		this.inicio = inicio;
		this.idPol=id;
	}
	public Poliza() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(inicio, idPol);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poliza other = (Poliza) obj;
		return Objects.equals(inicio, other.inicio) && Objects.equals(idPol, other.idPol);
	}
	@Override
	public String toString() {
		return "Poliza [numero=" + idPol + ", inicio=" + inicio + "]";
	}
	
}
