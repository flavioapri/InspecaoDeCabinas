package com.flavio.inspecaodecabinas.modelo;

/**
 * Criado por...
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Baumuster {
	private int id;
	private String codigo;
	private String modelo;

	public Baumuster() {}

	public Baumuster(int id, String codigo, String modelo) {
		this.id = id;
		this.codigo = codigo;
		this.modelo = modelo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
