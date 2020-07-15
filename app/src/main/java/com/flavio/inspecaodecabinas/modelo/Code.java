package com.flavio.inspecaodecabinas.modelo;

/**
 * Criado por...
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Code {
	private int id;
	private String codigo;
	private String denominacao;
	private String descricao;

	public Code() {
	}

	public Code(int id, String codigo, String denominacao, String descricao) {
		this.id = id;
		this.codigo = codigo;
		this.denominacao = denominacao;
		this.descricao = descricao;
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

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
