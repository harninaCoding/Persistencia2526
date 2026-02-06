package com.adorno.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class IdentificadorVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//si pones  el set es private esta haciendo una clase inmutable
	private String identificador;

	
	public IdentificadorVO(String identificador) {
		super();
		setIdentificador(identificador);
	}
	

	//JPA necesita el contrstutor vacio
	public IdentificadorVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		return Objects.hash(identificador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentificadorVO other = (IdentificadorVO) obj;
		return Objects.equals(identificador, other.identificador);
	}

	public String getIdentificador() {
		return identificador;
	}

	private void setIdentificador(String identificador) {
		//////////////////////////Clausulas de guarda
		if(identificador.length()!=7) throw new IllegalArgumentException("longitud no validad");
		if(!comprobarForma(identificador)) throw new IllegalArgumentException("");
		if(!comprobarLimiteInferior(extraeNumericos(identificador))) throw new IllegalArgumentException();
		/////////////////////////
		/// El parametro supera las guardas
		this.identificador=identificador;
	}

	/**
	 * Comprueba que tiene la forma indicada por regla de dominio
	 * @param identificador2 del socio
	 * @return true si la forma es dos letras+cinco numeros false en contrario
	 */
	private boolean comprobarForma(String identificador2) {
		String letras = identificador2.substring(0,2);
		for (int i = 0; i < letras.length(); i++) {
			char charAt = letras.charAt(i);
			if(!Character.isAlphabetic(charAt)) return false;
		}
		String numeros = identificador2.substring(3);
		for (int i = 0; i < numeros.length(); i++) {
			char charAt = numeros.charAt(i);
			if(!Character.isDigit(charAt)) return false;
		}
		return true;
	}

	private boolean comprobarLimiteInferior(Integer valor) {
		int limiteInferior = 120;
		return valor>=limiteInferior;
	}
	private Integer extraeNumericos(String identificador) {
		return Integer.valueOf(identificador.substring(2, identificador.length()));
	}
	
	
}
