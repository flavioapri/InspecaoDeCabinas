package com.flavio.inspecaodecabinas.modelo;

/**
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Pais {
	private int id;
	private String codigo;
	private String nome;

	public Pais() {
	}

	public Pais(int id, String codigo, String nome) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
