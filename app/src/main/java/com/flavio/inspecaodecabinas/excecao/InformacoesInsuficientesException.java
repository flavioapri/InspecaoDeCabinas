package com.flavio.inspecaodecabinas.excecao;

/**
 * A string com as informações da cabina não possuem a quantidade mínima de 4 para ter integridade.
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class InformacoesInsuficientesException extends InspecaoCabinasException {
	public InformacoesInsuficientesException() {
		super("Informações insuficientes da cabina.");
	}
}
