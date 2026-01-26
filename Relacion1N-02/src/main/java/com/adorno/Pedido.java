package com.adorno;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic(optional = false)
	@Column(nullable = false, unique = true)
	private Long identificadorExterno;
	private LocalDate localDate;
	private double aoumnt;

	
	public Pedido(LocalDate localDate, double aoumnt) {
		super();
		this.localDate = localDate;
		this.aoumnt = aoumnt;
	}

	public Pedido() {
		super();
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public double getAoumnt() {
		return aoumnt;
	}

	public void setAoumnt(double aoumnt) {
		this.aoumnt = aoumnt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(aoumnt, identificadorExterno, localDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Double.doubleToLongBits(aoumnt) == Double.doubleToLongBits(other.aoumnt)
				&& Objects.equals(identificadorExterno, other.identificadorExterno)
				&& Objects.equals(localDate, other.localDate);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + identificadorExterno + ", localDate=" + localDate + ", aoumnt=" + aoumnt + "]";
	}

}
