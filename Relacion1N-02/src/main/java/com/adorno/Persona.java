package com.adorno;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Para crear una clave que si permita la busqueda del elemento sin usar el id
	// Basic no afecta a la bbdd
	@Basic(optional = false)
	// caracteristicas que si son de la bbdd
	@Column(nullable = false, unique = true)
	@NonNull
	private Long identificadorExterno;
	@NonNull
	private String nombre;
	@NonNull
	private String apellidos;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.EAGER)
	private List<Pedido> pedidos;

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, identificadorExterno, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos)
				&& Objects.equals(identificadorExterno, other.identificadorExterno)
				&& Objects.equals(nombre, other.nombre);
	}

}
