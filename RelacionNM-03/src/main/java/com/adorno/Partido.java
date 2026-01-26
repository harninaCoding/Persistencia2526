package com.adorno;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String EquipoUno;
	@NonNull
	private String EquipoDos;

	// o sea, como esta no tiene mappedby, es la dueña de la relacion, porque este
	// es la clase
	// que hace los insert/deletes en la tabla intermedia, al no poner mmapedby aqui
	// le estamos
//	dando la responsabilidad de gestionar la relacion a esta clase
	@ManyToMany
	private List<Persona> personas;

//Esto agrega este trozo de codigo a cualquier constructor
	{
		personas = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(EquipoDos, EquipoUno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(EquipoDos, other.EquipoDos) && Objects.equals(EquipoUno, other.EquipoUno);
	}

	@Override
	public String toString() {
		return "Partido [EquipoUno=" + EquipoUno + ", EquipoDos=" + EquipoDos + "]";
	}

}
