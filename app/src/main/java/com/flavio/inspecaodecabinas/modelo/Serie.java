package com.flavio.inspecaodecabinas.modelo;

/**
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Serie extends EntidadeBase {
	private String numero;
	private Baumuster baumuster;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Baumuster getBaumuster() {
		return baumuster;
	}

	public void setBaumuster(Baumuster baumuster) {
		this.baumuster = baumuster;
	}
}
