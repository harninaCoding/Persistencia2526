package com.adorno;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
//@Data En vez de esto
//constructor sin argumentos obligatorio para jpa
@NoArgsConstructor
//construtor con argumentos obligatorios, necesario para obviar el id
@RequiredArgsConstructor
@Getter
@Setter
public class Pedido {

	///////////// patron Surrogate Key + Natural (Business) Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic(optional = false)
	@Column(nullable = false, unique = true)
	@NonNull
	private Long identificadorExterno;
	///////////////////////////////////////////////////////////////
	@NonNull
	private LocalDate localDate;
	@NonNull
	private double aoumnt;
	// expresamos la relacion, primero la dueña
	@NonNull
	@ManyToOne
	//si quieres poner el nombre de la columna en la bbdd
	@JoinColumn(name = "id_humano", nullable = false)
	private Persona persona;

	@Override
	public String toString() {
		return "Pedido [id=" + identificadorExterno + ", localDate=" + localDate + ", aoumnt=" + aoumnt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificadorExterno, localDate, persona);
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
		return Objects.equals(identificadorExterno, other.identificadorExterno)
				&& Objects.equals(localDate, other.localDate) && Objects.equals(persona, other.persona);
	}

}
