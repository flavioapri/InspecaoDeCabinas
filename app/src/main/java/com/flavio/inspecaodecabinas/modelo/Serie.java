package com.flavio.inspecaodecabinas.modelo;

/**
 * Criado por...
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Serie {
	private int id;
	private String serie;
	private Baumuster baumuster;

	public Serie() {
	}

	public Serie(int id, String serie, Baumuster baumuster) {
		this.id = id;
		this.serie = serie;
		this.baumuster = baumuster;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Baumuster getBaumuster() {
		return baumuster;
	}

	public void setBaumuster(Baumuster baumuster) {
		this.baumuster = baumuster;
	}
}
