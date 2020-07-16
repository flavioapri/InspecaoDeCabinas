package com.flavio.inspecaodecabinas.modelo;

/**
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Pais extends EntidadeBase {
	private String codigo;
	private String nome;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
