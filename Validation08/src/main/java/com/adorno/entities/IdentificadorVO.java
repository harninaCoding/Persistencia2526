package com.adorno.entities;

public class IdentificadorVO {
	//si pones  el set es private esta haciendo una clase inmutable
	private String identificador;

	
	public IdentificadorVO(String identificador) {
		super();
		setIdentificador(identificador);
	}

	public String getIdentificador() {
		return identificador;
	}

	private void setIdentificador(String identificador) {
		//////////////////////////Clausulas de guarda
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
		// TODO Auto-generated method stub
		return false;
	}

	private boolean comprobarLimiteInferior(Integer valor) {
		int limiteInferior = 120;
		return valor>limiteInferior;
	}
	private Integer extraeNumericos(String identificador) {
		return Integer.valueOf(identificador.substring(2, identificador.length()));
	}
	
	
}
