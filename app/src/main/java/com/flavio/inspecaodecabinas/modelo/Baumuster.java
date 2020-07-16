package com.flavio.inspecaodecabinas.modelo;

/**
 * Representa um objeto do tipo <b>Baumuster</b>.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Baumuster extends EntidadeBase {
	private String codigo;
	private String modelo;

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
