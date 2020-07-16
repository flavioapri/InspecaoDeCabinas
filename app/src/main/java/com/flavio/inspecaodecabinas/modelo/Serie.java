package com.flavio.inspecaodecabinas.modelo;

/**
 * Criado por...
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Serie {
	private int id;
	private String numero;
	private Baumuster baumuster;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
