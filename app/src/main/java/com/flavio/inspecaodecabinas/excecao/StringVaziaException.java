package com.flavio.inspecaodecabinas.excecao;

/**
 * Criado por...//TODO Documentar
 *
 * @author Flávio Aparecido Ribeiro
 * @version 1.0
 */
public class StringVaziaException extends InspecaoCabinasException {
	public StringVaziaException() {
		super("A String esta vazia. Não contém informações");
	}
}
