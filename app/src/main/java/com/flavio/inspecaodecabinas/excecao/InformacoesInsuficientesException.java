package com.flavio.inspecaodecabinas.excecao;

/**
 * Criado por...//TODO Documentar
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class InformacoesInsuficientesException extends InspecaoCabinasException {
	public InformacoesInsuficientesException() {
		super("Informações insuficientes da cabina.");
	}
}
