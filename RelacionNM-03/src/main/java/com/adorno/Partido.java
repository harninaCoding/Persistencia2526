package com.adorno;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	private List<Persona> personas;

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
