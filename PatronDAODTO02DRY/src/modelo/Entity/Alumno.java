package modelo.Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {
	private String matricula;
	private String apellidos;
	private String nombre;
	private String sexo;
	private LocalDate fechaNacimiento;

	public Alumno() {
		super();
	}

	public Alumno(String matricula, String apellidos, String nombre, String sexo, LocalDate fechaNacimiento) {
		super();
		this.matricula = matricula;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
	}

	private String getMatricula() {
		return matricula;
	}

	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	private String getApellidos() {
		return apellidos;
	}

	private void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String getSexo() {
		return sexo;
	}

	private void setSexo(String sexo) {
		this.sexo = sexo;
	}

	private LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	private void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Alumno [matricula=" + matricula + ", apellidos=" + apellidos + ", nombre=" + nombre + ", sexo=" + sexo
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, fechaNacimiento, matricula, nombre, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(sexo, other.sexo);
	}

}
