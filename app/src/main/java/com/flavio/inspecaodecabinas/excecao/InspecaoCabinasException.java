package com.flavio.inspecaodecabinas.excecao;

/**
 * //TODO Documentar
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class InspecaoCabinasException extends Exception {
	private String msg;

	public InspecaoCabinasException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
}
