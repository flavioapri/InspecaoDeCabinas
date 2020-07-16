package com.flavio.inspecaodecabinas.modelo;

/**
 * Representa um objeto do tipo <b>Code</b>
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class Code extends EntidadeBase {
	private String codigo;
	private String denominacao;
	private String descricao;

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
